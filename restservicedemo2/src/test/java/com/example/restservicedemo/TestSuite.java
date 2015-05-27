package com.example.restservicedemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   LastFmTest.class,
   CarServiceTest.class,
   PersonTest.class,
   DbUnit.class,
   SpecialTest.class
   
})
public class TestSuite {   
}  
