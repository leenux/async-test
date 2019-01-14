## Prerequisite or my prerequisite
- ubuntu 18.04
- oracle jdk 8
- docker and docker-compose

## How to run?
- cd src path
- docker-compose -f citus.yml
- docker-compose -f cockroach.yml
- docker exec -it roach-0 /bin/bash
- ./cockroach sql --insecure
- in sql state exec below sql
- CREATE DATABASE cherry;
- CREATE USER IF NOT EXISTS cherry;
- GRANT ALL ON DATABASE cherry TO cherry;
- cd bin
- java -jar test.jar

Please waiting for error and can't input any press
## Output example
```
2019-01-14 14:28:06.664 [DefaultDispatcher-worker-1] INFO  c.g.jasync.sql.db.util.NettyUtils - jasync selected transport - nio
2019-01-14 14:28:06.706 [DefaultDispatcher-worker-1] INFO  c.g.j.s.db.pool.ActorBasedObjectPool - registering pool for periodic connection tests com.github.jasync.sql.db.pool.ActorBasedObjectPool@3e3cd86d - PoolConfiguration(maxObjects=1, maxIdle=60000, maxQueueSize=2147483647, validationInterval=5000, createTimeout=5000, testTimeout=5000, queryTimeout=null)
2019-01-14 14:28:06.941 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.c.PostgreSQLConnectionHandler - Authentication response received com.github.jasync.sql.db.postgresql.messages.backend.AuthenticationChallengeMD5@7c813c21
2019-01-14 14:28:06.957 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.c.PostgreSQLConnectionHandler - Authentication response received com.github.jasync.sql.db.postgresql.messages.backend.AuthenticationOkMessage@bafd901
2019-01-14 14:28:06.958 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.PostgreSQLConnection - Successfully logged in to database
2019-01-14 14:28:06.980 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.PreparedStatementOpeningEncoder - Opening query (select * from user) - statement id (49) - selected types () - values ()
2019-01-14 14:28:06.982 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.PreparedStatementEncoderHelper - Preparing execute portal to statement (select * from user) - values () - UTF-8
2019-01-14 14:28:06.982 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.PreparedStatementEncoderHelper - Executing portal - statement id (49) - statement (select * from user) - encoded values () - original values ()
2019-01-14 14:28:06.997 [DefaultDispatcher-worker-1] DEBUG com.leenux.Application - getPgAsync------------
2019-01-14 14:28:06.998 [main] INFO  com.leenux.Application - This is result from postgre---cherry-
2019-01-14 14:28:06.999 [DefaultDispatcher-worker-2] INFO  c.g.j.s.db.pool.ActorBasedObjectPool - registering pool for periodic connection tests com.github.jasync.sql.db.pool.ActorBasedObjectPool@3047651c - PoolConfiguration(maxObjects=1, maxIdle=60000, maxQueueSize=2147483647, validationInterval=5000, createTimeout=5000, testTimeout=5000, queryTimeout=null)
2019-01-14 14:28:07.014 [db-sql-netty-thread-2] DEBUG c.g.j.s.d.p.c.PostgreSQLConnectionHandler - Authentication response received com.github.jasync.sql.db.postgresql.messages.backend.AuthenticationOkMessage@bafd901
2019-01-14 14:28:07.016 [db-sql-netty-thread-2] DEBUG c.g.j.s.d.p.PostgreSQLConnection - Successfully logged in to database
2019-01-14 14:28:07.023 [db-sql-netty-thread-2] DEBUG c.g.j.s.d.p.e.PreparedStatementOpeningEncoder - Opening query (select * from user) - statement id (49) - selected types () - values ()
2019-01-14 14:28:07.024 [db-sql-netty-thread-2] DEBUG c.g.j.s.d.p.e.PreparedStatementEncoderHelper - Preparing execute portal to statement (select * from user) - values () - UTF-8
2019-01-14 14:28:07.024 [db-sql-netty-thread-2] DEBUG c.g.j.s.d.p.e.PreparedStatementEncoderHelper - Executing portal - statement id (49) - statement (select * from user) - encoded values () - original values ()
2019-01-14 14:28:07.071 [DefaultDispatcher-worker-2] DEBUG com.leenux.Application - getCockAsync------------
2019-01-14 14:28:07.074 [main] INFO  com.leenux.Application - This is result from cockroach---cherry-
2019-01-14 14:28:11.717 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.QueryMessageEncoder - Executing direct query (SELECT 0)
2019-01-14 14:28:12.002 [db-sql-netty-thread-2] DEBUG c.g.j.s.d.p.e.QueryMessageEncoder - Executing direct query (SELECT 0)
2019-01-14 14:28:12.014 [db-sql-netty-thread-2] ERROR c.g.j.s.d.p.PostgreSQLConnection - Error , message -> ErrorMessage(fields=[(Severity, ERROR), (SQLSTATE, 08P01), (File, sql/pgwire/pgwirebase/encoding.go), (Line, 189), (Routine, NewProtocolViolationErrorf), (Message, SimpleQuery not allowed while in extended protocol mode)])
2019-01-14 14:28:12.020 [db-sql-netty-thread-2] ERROR c.g.j.s.d.p.PostgreSQLConnection - Error on connection
com.github.jasync.sql.db.postgresql.exceptions.GenericDatabaseException: ErrorMessage(fields=[(Severity, ERROR), (SQLSTATE, 08P01), (File, sql/pgwire/pgwirebase/encoding.go), (Line, 189), (Routine, NewProtocolViolationErrorf), (Message, SimpleQuery not allowed while in extended protocol mode)])
        at com.github.jasync.sql.db.postgresql.PostgreSQLConnection.onError(PostgreSQLConnection.kt:200)
        at com.github.jasync.sql.db.postgresql.codec.PostgreSQLConnectionHandler.channelRead0(PostgreSQLConnectionHandler.kt:197)
        at io.netty.channel.SimpleChannelInboundHandler.channelRead(SimpleChannelInboundHandler.java:105)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:323)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:310)
        at io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:426)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:278)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340)
        at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1434)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:965)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:163)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:656)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:591)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:508)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:470)
        at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:909)
        at java.lang.Thread.run(Thread.java:748)
2019-01-14 14:28:12.022 [db-sql-netty-thread-2] ERROR c.g.j.s.d.p.PostgreSQLConnection - Setting error on future java.util.concurrent.CompletableFuture@18bd078[Not completed, 1 dependents]
2019-01-14 14:28:12.029 [db-sql-netty-thread-2] INFO  c.g.j.s.d.p.c.PostgreSQLConnectionHandler - Connection disconnected - localhost/127.0.0.1:26257
2019-01-14 14:28:16.710 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.QueryMessageEncoder - Executing direct query (SELECT 0)
2019-01-14 14:28:21.711 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.QueryMessageEncoder - Executing direct query (SELECT 0)
2019-01-14 14:28:26.711 [db-sql-netty-thread-1] DEBUG c.g.j.s.d.p.e.QueryMessageEncoder - Executing direct query (SELECT 0)

2019-01-14 14:28:27.760 [main] INFO  c.g.j.s.db.pool.ActorBasedObjectPool - closing the pool
2019-01-14 14:28:27.764 [db-sql-netty-thread-1] INFO  c.g.j.s.d.p.c.PostgreSQLConnectionHandler - Connection disconnected - localhost/127.0.0.1:5432
2019-01-14 14:28:27.767 [main] INFO  c.g.j.s.db.pool.ActorBasedObjectPool - closing the pool
``` 