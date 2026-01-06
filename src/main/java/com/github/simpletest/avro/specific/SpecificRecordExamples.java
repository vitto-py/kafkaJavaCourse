package com.github.simpletest.avro.specific;

import com.example.Customer;
import org.apache.avro.specific.SpecificRecord;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecificRecordExamples {
    public static void main(String[] args) {
        // CREATE SPECIFIC RECORD
        Customer.Builder customerBuilder = Customer.newBuilder();
        customerBuilder.setAge(25);
        customerBuilder.setWeight(90);
        customerBuilder.setFirstName("John");
        customerBuilder.setLastName("Rivers");
        customerBuilder.setCustomerEmails(Arrays.asList("jonh1@example.com", "jonh2@example.com"));
        SpecificRecord customer1 = customerBuilder.build();

        //Print
        System.out.println(customer1);
    }
}
