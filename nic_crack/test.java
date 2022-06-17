import java.time.LocalDate;
import java.time.Year;
import java.util.*;

class Example {
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the NIC Number : ");
            long nic = in.nextLong();
            long[] nicAr = new long[12];

            int i = 0;
            while (nic != 0) {
                nicAr[(nicAr.length - 1) - i] = nic % 10;
                nic /= 10;
                i++;
            }
            System.out.println(Arrays.toString(nicAr));
            int doy = 0;
            doy += nicAr[0] * 1000;
            doy += nicAr[1] * 100;
            doy += nicAr[2] * 10;
            doy += nicAr[3];

            System.out.print("Birth Year : ");
            for (int j = 0; j < 4; j++) {
                System.out.print(nicAr[j]);
            }
            System.out.println();
            int dayOfB = 0;

            dayOfB += nicAr[4] * 100;
            dayOfB += nicAr[5] * 10;
            dayOfB += nicAr[6];
            System.out.print("Gender");
            if (dayOfB >= 366) {
                System.out.println("\nFemale");
                dayOfB -= 500;
            } else {
                System.out.println("\nMale");
            }
            Year y = Year.of(doy);
            LocalDate Id = y.atDay(dayOfB - 1);
            System.out.print("Date of Birth: ");
            System.out.println(Id);
        }
    }
}