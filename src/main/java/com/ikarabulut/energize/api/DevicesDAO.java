package com.ikarabulut.energize.api;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface DevicesDAO {
    @SqlQuery("SELECT state FROM <table> WHERE UUID = :uuid")
    boolean getDeviceState(@Define("table") String table, @Bind("uuid") String uuid);

    @SqlUpdate("INSERT INTO <table> (UUID, STATE) VALUES (:uuid, :charging) ON CONFLICT (UUID) DO UPDATE SET STATE = EXCLUDED.STATE")
    void setDeviceState(@Define("table")String table,
                        @Bind("uuid")String uuid, @Bind("charging")boolean charging);
}
