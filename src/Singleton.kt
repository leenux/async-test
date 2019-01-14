package com.leenux

import com.github.jasync.sql.db.pool.ConnectionPool
import com.github.jasync.sql.db.postgresql.PostgreSQLConnection
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder

object DbOne {
    val Pool: ConnectionPool<PostgreSQLConnection> by lazy {
        PostgreSQLConnectionBuilder.createConnectionPool(
            url = "postgres://cherry@localhost:5432/cherry?user=cherry&password=cherry&sslmode=disable"
        )
    }

    val CockPool: ConnectionPool<PostgreSQLConnection> by lazy {
        PostgreSQLConnectionBuilder.createConnectionPool(
            url = "postgres://cherry@localhost:26257/cherry?user=cherry&sslmode=disable"
        )
    }
}

