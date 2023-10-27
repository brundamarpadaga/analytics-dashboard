//package com.example.analyticsdashboard.config;
//
//
//import de.flapdoodle.embed.mongo.MongodExecutable;
//import de.flapdoodle.embed.mongo.MongodStarter;
//import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;
//import de.flapdoodle.embed.process.runtime.Network;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//
//import com.mongodb.client.MongoClient;
//
//import static de.flapdoodle.embed.mongo.distribution.Version.Main.PRODUCTION;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//import org.springframework.context.annotation.Profile;
//
//
//@Configuration
//@Profile("test")
//public class EmbeddedMongoConfig {
//	
//	
//	private static final String IP = "localhost";
//    private static final int PORT = 28017; 
////    @Bean
////    public IMongodConfig embeddedMongoConfiguration() throws IOException {
////        return new MongodConfigBuilder()
////                .version(Version.V4_0_2)
////                .net(new Net(IP, PORT, Network.localhostIsIPv6()))
////                .build();
////    }
////	
////	 @Autowired
////	 private MongoClient mongoClient;
////
////	    @Bean(destroyMethod = "close")
////	    public MongoClient mongoClient() throws IOException {
////	        MongodForTestsFactory factory = MongodForTestsFactory.with("Version.V3_5_3");
////	        return factory.newMongo();
////	    }
////
////	    @Bean
////	    @Primary
////	    public MongoTemplate mongoTemplate() {
////	        return new MongoTemplate(mongoClient, "testDB");
////	    }
//}


