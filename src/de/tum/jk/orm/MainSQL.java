package de.tum.jk.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.LogManager;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;

import de.tum.jk.orm.pojos.unischema.tables.Hoeren;
import de.tum.jk.orm.pojos.unischema.tables.Studenten;
import de.tum.jk.orm.pojos.unischema.tables.Vorlesungen;
import de.tum.jk.orm.pojos.unischema.tables.records.HoerenRecord;
import de.tum.jk.orm.pojos.unischema.tables.records.StudentenRecord;
import de.tum.jk.orm.pojos.unischema.tables.records.VorlesungenRecord;

public class MainSQL {

	static DSLContext create;

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(MainGeneration.SERVER_URL, MainGeneration.USER,
				MainGeneration.PASSWORD)) {
			create = DSL.using(conn, SQLDialect.MYSQL);

			//create a JOIN on Studenten Hoeren and Vorlesungen
			joinStudentenHoerenVorlesungen();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createStudent(StudentenRecord student) {
		StudentenRecord s = create.newRecord(Studenten.STUDENTEN);
		s.from(student);
		s.store();
	}

	private static void updateStudent(StudentenRecord studentenRecord) {
		studentenRecord.attach(create.configuration());
		studentenRecord.update();

	}

	private static void insertStudent(StudentenRecord studentenRecord) {
		try {
			studentenRecord.attach(create.configuration());
			studentenRecord.insert();
		} catch (DataAccessException e) {
			System.out.println("could not be added due to constrain violation\n" + e);
		}

	}

	private static void joinStudentenHoerenVorlesungen() {
		Result<Record> joinResult = create.select()
				.from(Studenten.STUDENTEN)
				.join(Hoeren.HOEREN).on(Studenten.STUDENTEN.MATRNR.eq(Hoeren.HOEREN.MATRNR))
				.join(Vorlesungen.VORLESUNGEN).on(Hoeren.HOEREN.VORLNR.eq(Vorlesungen.VORLESUNGEN.VORLNR))
				.fetch();
		for (Record r : joinResult) {
			/**
			 * You can access the different tables of the join also individually if you need
			 * to
			 * 
			 * StudentenRecord s = r.into(Studenten.STUDENTEN); 
			 * HoerenRecord h = r.into(Hoeren.HOEREN); 
			 * VorlesungenRecord v = r.into(Vorlesungen.VORLESUNGEN);
			 */
			System.out.println(r);
		}
	}

	static {
		LogManager.getLogManager().reset();
	}

}
