package task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskManagerr {
    static class Task {
        private int id;
        private String title;
        private boolean isDone;
        private LocalDate createdAt;
        private LocalDate deadline;

        public Task(int id, String title, LocalDate deadline) {
            this.id = id;
            this.title = title;
            this.deadline = deadline;
            this.isDone = false;
            this.createdAt = LocalDate.now();
        }

        public int getId() { return id; }
        public String getTitle() { return title; }
        public boolean isDone() { return isDone; }
        public void markDone() { isDone = true; }
        public LocalDate getCreatedAt() { return createdAt; }
        public LocalDate getDeadline() { return deadline; }

        public void display() {
            System.out.println("ID: " + id);
            System.out.println("Tên: " + title);
            System.out.println("Trạng thái: " + (isDone ? "✅ Hoàn thành" : "❌ Chưa hoàn thành"));
            System.out.println("Ngày tạo: " + createdAt);
            System.out.println("Hạn chót: " + deadline);
            System.out.println("--------------------------");
        }
    }


    private ArrayList<Task> taskList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addTask() {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên công việc: ");
            String name = sc.nextLine();
            System.out.print("Nhập hạn chót (yyyy-mm-dd): ");
            LocalDate deadline = LocalDate.parse(sc.nextLine());

            taskList.add(new Task(id, name, deadline));
            System.out.println("✅ Đã thêm công việc.");
        } catch (Exception e) {
            System.out.println("❌ Lỗi nhập dữ liệu. Vui lòng thử lại.");
        }
    }

    public void markTaskDone() {
        System.out.print("Nhập ID công việc cần đánh dấu hoàn thành: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.markDone();
                System.out.println("✅ Đã cập nhật trạng thái.");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy công việc.");
    }

    public void sortByDeadline() {
        taskList.sort(Comparator.comparing(Task::getDeadline));
        System.out.println("📅 Danh sách công việc theo deadline:");
        for (Task task : taskList) {
            task.display();
        }
    }

    public void printStatistics() {
        long done = taskList.stream().filter(Task::isDone).count();
        long notDone = taskList.size() - done;

        System.out.println("📊 Thống kê công việc:");
        System.out.println("✅ Hoàn thành: " + done);
        System.out.println("❌ Chưa hoàn thành: " + notDone);
    }

    public void displayAll() {
        if (taskList.isEmpty()) {
            System.out.println("📭 Không có công việc nào.");
            return;
        }
        for (Task task : taskList) {
            task.display();
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n===== MENU QUẢN LÝ CÔNG VIỆC =====");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Hiển thị danh sách công việc");
            System.out.println("3. Đánh dấu hoàn thành");
            System.out.println("4. Sắp xếp theo deadline");
            System.out.println("5. Thống kê công việc");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addTask();
                case 2 -> displayAll();
                case 3 -> markTaskDone();
                case 4 -> sortByDeadline();
                case 5 -> printStatistics();
                case 0 -> System.out.println("👋 Tạm biệt!");
                default -> System.out.println("⚠️ Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        TaskManagerr manager = new TaskManagerr();
        manager.menu();
    }
}
