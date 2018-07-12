package de.tum.jk.orm;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

public class MainGeneration {

	public static final String SERVER_URL = "jdbc:mysql://mse18.cpen2a54lqju.eu-west-1.rds.amazonaws.com:3306/unischema";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DEFAULT_GENERATOR = "org.jooq.codegen.DefaultGenerator";
	private static final String EXCLUDE_TABLES = "(?i:information_schema\\..*) | (?i:performance_schema\\..*) | (?i:mysql\\..*) | (?i:sys\\..*)";
	private static final String DATABASE_TYPE = "org.jooq.meta.mysql.MySQLDatabase";
	private static final String EXPORT_PACKAGE = "de.tum.jk.orm.pojos";
	private static final String EXPORT_DIRECTORY = "src";

	public static void main(String[] args) throws Exception {

		/**
		 * We are using the Builder Pattern to setup our configuration
		 * alternatively you can also run GenerationTool.generate(); passing the library.xml as an argument for this oyu need to create a run
		 *  configuration in eclipse see: https://www.jooq.org/doc/3.11/manual-single-page/#code-generation
		 *  
		 */
		 Configuration configuration = new Configuration()
		 .withJdbc(new Jdbc() // We want to use the Java Database Connectivity
		 .withDriver(DRIVER) //The Driver should be for a MySQL Database you can also connect other databases using other drivers
		 .withUrl(SERVER_URL) //Our server URL to connect to
		 .withUser(USER) //The User for authentication
		 .withPassword(PASSWORD)) // The password for authentication
		 .withGenerator(new Generator().withName(DEFAULT_GENERATOR) //The Generator from JOOQ to generate our Java Classes
		 .withDatabase(new Database()
		 .withName(DATABASE_TYPE) //The Database Type to be used by the framework (has to align with the driver used)
		 .withIncludes(".*").withExcludes(EXCLUDE_TABLES)) //OPTIONAL: Exclusion filters for Tables which should not be generated
		 .withTarget(new Target()
		 .withPackageName(EXPORT_PACKAGE) //Package definition of the generated Java Classes
		 .withDirectory(EXPORT_DIRECTORY))); // Export directory where to store the generated Java Classes
		
		 GenerationTool.generate(configuration);

	}
}
