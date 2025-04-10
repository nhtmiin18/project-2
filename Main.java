package task;




public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        JobService jobService = new JobService();
        while (true) {
            System.out.println("\n======= MENU =======");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Xóa công việc");
            System.out.println("3. Cập nhật công việc");
            System.out.println("4. Xem danh sách công việc");
            System.out.println("5. Tìm kiếm công việc (title)");
            System.out.println("6. Lọc công việc theo vị trí & lương");
            System.out.println("7. Đọc file + commit");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tên công việc: ");
                    String name = scanner.nextLine();
                    System.out.print("Trạng thái: ");
                    String status = scanner.nextLine();
                    Task task = new Task(id, name, status, LocalDate.now());
                    manager.addTask(task);
                }
                case 2 -> {
                    System.out.print("Nhập ID cần xóa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (!manager.removeTask(id)) {
                        System.out.println("❌ Không tìm thấy công việc ID: " + id);
                    } else {
                        System.out.println("✅ Đã xóa công việc.");
                    }
                }
                case 3 -> {
                    System.out.print("ID cần cập nhật: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tên mới: ");
                    String name = scanner.nextLine();
                    System.out.print("Trạng thái mới: ");
                    String status = scanner.nextLine();
                    Task task = new Task(id, name, status, LocalDate.now());
                    if (manager.updateTask(task)) {
                        System.out.println("✅ Đã cập nhật.");
                    } else {
                        System.out.println("❌ Không tìm thấy công việc.");
                    }
                }
                case 4 -> {
                    System.out.println("--- DANH SÁCH CÔNG VIỆC ---");
                    for (Task task : manager.getAllTasks()) System.out.println(task);
                }
                case 5 -> {
                    System.out.print("Nhập từ khóa: ");
                    String keyword = scanner.nextLine();
                    List<Job> jobs = jobService.searchByTitle(keyword);
                    jobs.forEach(System.out::println);
                }
                case 6 -> {
                    System.out.print("Nhập vị trí: ");
                    String location = scanner.nextLine();
                    System.out.print("Nhập lương tối thiểu: ");
                    double minSalary = Double.parseDouble(scanner.nextLine());
                    List<Job> jobs = jobService.filterByLocationAndSalary(location, minSalary);
                    jobs.forEach(System.out::println);
                }
                case 7 -> readFileAndCommit(scanner);
                case 0 -> {
                    System.out.println("👋 Thoát chương trình.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("⚠️ Lựa chọn không hợp lệ!");
            }
        }
    }