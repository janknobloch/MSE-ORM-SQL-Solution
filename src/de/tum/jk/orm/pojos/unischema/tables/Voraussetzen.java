/*
 * This file is generated by jOOQ.
 */
package de.tum.jk.orm.pojos.unischema.tables;


import de.tum.jk.orm.pojos.unischema.Indexes;
import de.tum.jk.orm.pojos.unischema.Keys;
import de.tum.jk.orm.pojos.unischema.Unischema;
import de.tum.jk.orm.pojos.unischema.tables.records.VoraussetzenRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Voraussetzen extends TableImpl<VoraussetzenRecord> {

    private static final long serialVersionUID = 949428218;

    /**
     * The reference instance of <code>unischema.voraussetzen</code>
     */
    public static final Voraussetzen VORAUSSETZEN = new Voraussetzen();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VoraussetzenRecord> getRecordType() {
        return VoraussetzenRecord.class;
    }

    /**
     * The column <code>unischema.voraussetzen.Vorgaenger</code>.
     */
    public final TableField<VoraussetzenRecord, Integer> VORGAENGER = createField("Vorgaenger", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>unischema.voraussetzen.Nachfolger</code>.
     */
    public final TableField<VoraussetzenRecord, Integer> NACHFOLGER = createField("Nachfolger", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>unischema.voraussetzen</code> table reference
     */
    public Voraussetzen() {
        this(DSL.name("voraussetzen"), null);
    }

    /**
     * Create an aliased <code>unischema.voraussetzen</code> table reference
     */
    public Voraussetzen(String alias) {
        this(DSL.name(alias), VORAUSSETZEN);
    }

    /**
     * Create an aliased <code>unischema.voraussetzen</code> table reference
     */
    public Voraussetzen(Name alias) {
        this(alias, VORAUSSETZEN);
    }

    private Voraussetzen(Name alias, Table<VoraussetzenRecord> aliased) {
        this(alias, aliased, null);
    }

    private Voraussetzen(Name alias, Table<VoraussetzenRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Voraussetzen(Table<O> child, ForeignKey<O, VoraussetzenRecord> key) {
        super(child, key, VORAUSSETZEN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Unischema.UNISCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.VORAUSSETZEN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<VoraussetzenRecord> getPrimaryKey() {
        return Keys.KEY_VORAUSSETZEN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<VoraussetzenRecord>> getKeys() {
        return Arrays.<UniqueKey<VoraussetzenRecord>>asList(Keys.KEY_VORAUSSETZEN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Voraussetzen as(String alias) {
        return new Voraussetzen(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Voraussetzen as(Name alias) {
        return new Voraussetzen(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Voraussetzen rename(String name) {
        return new Voraussetzen(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Voraussetzen rename(Name name) {
        return new Voraussetzen(name, null);
    }
}