package doanchung3;
import java.io.*;
import java.util.Scanner;
public class zenzo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tới file cần đọc: ");
        String path = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println("\n--- Nội dung file ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }

        System.out.print("\nNhập commit message: ");
        String message = sc.nextLine();

        System.out.println("\n✅ COMMIT THÀNH CÔNG");
        System.out.println("File: " + path);
        System.out.println("Message: " + message);
        System.out.println("Thời gian: " + java.time.LocalDateTime.now());

	}

}
