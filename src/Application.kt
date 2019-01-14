package com.leenux

import kotlinx.coroutines.*
import kotlinx.coroutines.future.*
import mu.KotlinLogging
import java.io.Console

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    runBlocking {

        logger.info("This is result from postgre---${getPgAsync().await()}")
        logger.info("This is result from cockroach---${getCockAsync().await()}")
    }

    //You can wait for ... press return key until error log
    val rk = readLine()!!

    DbOne.Pool.disconnect().get()
    DbOne.CockPool.disconnect().get()
}

private fun getPgAsync(): Deferred<String> {
    return GlobalScope.async {
        val queryResult = DbOne.Pool.sendPreparedStatement("select * from user").await()
        logger.debug("getPgAsync------------")
        return@async queryResult.rows[0][0].toString() + "-"
    }
}

private fun getCockAsync(): Deferred<String> {
    return GlobalScope.async {
        val queryResult = DbOne.CockPool.sendPreparedStatement("select * from user").await()
        logger.debug("getCockAsync------------")
        return@async queryResult.rows[0][0].toString() + "-"
    }
}
