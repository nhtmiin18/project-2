package task1;
import java.time.LocalDate;
import java.util.*;

class Task {
    private String id;
    private String name;
    private String status;
    private LocalDate createdDate;

    // Constructor
    public Task(String id, String name, String status, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    // toString
    @Override
    public String toString() {
        return "Task{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Status='" + status + '\'' +
                ", Created Date=" + createdDate +
                '}';
    }
}

public class QuocHung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();

        System.out.print("Nhap ten nhiem vu: ");
        String name = scanner.nextLine();

        System.out.print("Nhap trang thai (Pending/In Progress/Completed): ");
        String status = scanner.nextLine();

        LocalDate createdDate = LocalDate.now(); // ngày tạo là hôm nay

        
        Task task = new Task(id, name, status, createdDate);

        System.out.println("\nThong tin nhiem vu:");
        System.out.println(task);

        scanner.close();
    }
}

