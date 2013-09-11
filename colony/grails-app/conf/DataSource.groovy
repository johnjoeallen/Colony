dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost:5432/colony"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"

            driverClassName = "org.postgresql.Driver"
            username = "colony"
            password = "colony"

            logSql = false

            properties { //db connection pool settings
                maxActive = 50
                maxIdle = 25
                minIdle = 1
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                numTestsPerEvictionRun = 3
                maxWait = 10000

                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                validationQuery = "SELECT 1"
            }

        }
    }
    test {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost:5432/colony"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"

            driverClassName = "org.postgresql.Driver"
            username = "colony"
            password = "colony"

            logSql = false

            properties { //db connection pool settings
                maxActive = 50
                maxIdle = 25
                minIdle = 1
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                numTestsPerEvictionRun = 3
                maxWait = 10000

                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                validationQuery = "SELECT 1"
            }

        }
    }
    production {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost:5432/colony"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"

            driverClassName = "org.postgresql.Driver"
            username = "colony"
            password = "colony"

            logSql = false

            properties { //db connection pool settings
                maxActive = 50
                maxIdle = 25
                minIdle = 1
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                numTestsPerEvictionRun = 3
                maxWait = 10000

                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                validationQuery = "SELECT 1"
            }

        }
    }
}
