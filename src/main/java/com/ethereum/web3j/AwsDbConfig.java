package com.ethereum.web3j;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import zipkin.server.EnableZipkinServer;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;


/**
 * @author I.T.W764
 */
//@EnableEurekaClient
//@EnableZipkinServer
//@ImportResource("classpath:/aws-config.xml")
//@Configuration
//@EnableAuthorizationServer
//@EnableResourceServer
//@EnableRdsInstance(
//        //        dbInstanceIdentifier = "db1instanceid",
//        dbInstanceIdentifier = "pubdbinstancebetr",
//        username = "istratitraian1",
//        databaseName = "betrdb",
//        password = "1234zxcv", readReplicaSupport = true
//)
//@EnableRdsInstance(databaseName = "${database-name:}", 
//                   dbInstanceIdentifier = "${db-instance-identifier:}", 
//				   password = "${rdsPassword:}")
public class AwsDbConfig {

//  @Value("${signing.key}")
//  private String jwtSigningKey = "";
//
//  public String getJwtSigningKey() {
//    return jwtSigningKey;
//  }

//  @Bean
//  public Sampler defaultSampler() {
//    return new AlwaysSampler();
//  }

//  @Bean
//  public RdsInstanceConfigurer instanceConfigurer() {
//    return () -> {
//      TomcatJdbcDataSourceFactory dataSourceFactory = new TomcatJdbcDataSourceFactory();
//      dataSourceFactory.setInitialSize(10);
//      dataSourceFactory.setValidationQuery("SELECT 1");
//      return dataSourceFactory;
//    };
//  }

  /*
  cloud.aws.rds.pubdbinstancebetr #RDS db instance name
  cloud.aws.rds.test.databaseName=betrdb
  cloud.aws.rds.test.password=1234zxcv
  cloud.aws.rds.test.username=istratitraian1
   */
}
