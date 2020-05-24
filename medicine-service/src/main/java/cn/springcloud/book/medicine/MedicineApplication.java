package cn.springcloud.book.medicine;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class MedicineApplication {
   
    public static void main(String[] args) {
        SpringApplication.run(MedicineApplication.class, args);
    }
}
