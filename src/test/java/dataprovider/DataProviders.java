package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
        @DataProvider(name="InvalidUserCredentials")
        public Object[][] userCredentialsData() {
            Object[][] data=new Object[3][2];
            data[0][0]="nanduvs@gmail.com";
            data[0][1]="123445";

            data[1][0]="nanduvs@gmail.com";
            data[1][1]="123456";

            data[2][0]="nanduvs01@gmail.com";
            data[2][1]="123455";
            return data;
        }
}
