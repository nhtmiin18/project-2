package MyQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class X {

    static class Job {
        private String title;
        private String location;
        private double salary;

        public Job(String title, String location, double salary) {
            this.title = title;
            this.location = location;
            this.salary = salary;
        }

        public String getTitle() {
            return title;
        }

        public String getLocation() {
            return location;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "title='" + title + '\'' +
                    ", location='" + location + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class JobService {
        private List<Job> jobs;

        public JobService() {
            jobs = new ArrayList<>();
            jobs.add(new Job("Java Developer", "Hanoi", 1200));
            jobs.add(new Job("Frontend Developer", "HCM", 1000));
            jobs.add(new Job("Backend Developer", "Hanoi", 1500));
            jobs.add(new Job("Tester", "Da Nang", 900));
        }

        public List<Job> searchByTitle(String keyword) {
            return jobs.stream()
                    .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }

        public List<Job> filterByLocationAndSalary(String location, double minSalary) {
            return jobs.stream()
                    .filter(job -> job.getLocation().equalsIgnoreCase(location) && job.getSalary() >= minSalary)
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        JobService jobService = new JobService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TÌM KIẾM CÔNG VIỆC ===");

        System.out.print("Nhập từ khóa công việc cần tìm: ");
        String keyword = scanner.nextLine();
        List<Job> resultByTitle = jobService.searchByTitle(keyword);
        System.out.println("\nKết quả tìm kiếm theo từ khóa:");
        resultByTitle.forEach(System.out::println);

        System.out.print("\nNhập vị trí cần tìm (ví dụ: Hanoi): ");
        String location = scanner.nextLine();
        System.out.print("Nhập mức lương tối thiểu: ");
        double salary = scanner.nextDouble();

        List<Job> resultByFilter = jobService.filterByLocationAndSalary(location, salary);
        System.out.println("\nCông việc phù hợp với vị trí và lương:");
        resultByFilter.forEach(System.out::println);

        scanner.close();
    }
}
