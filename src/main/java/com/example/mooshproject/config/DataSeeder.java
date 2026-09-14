package com.example.mooshproject.config;

import com.example.mooshproject.entity.Category;
import com.example.mooshproject.entity.Product;
import com.example.mooshproject.repository.CategoryRepository;
import com.example.mooshproject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {

        // Prevent duplicate seed data
        if (categoryRepository.count() > 0) {
            return;
        }

        // =========================
        // Categories
        // =========================

        Category processors = createCategory("Processors");
        Category graphicsCards = createCategory("Graphics Cards");
        Category motherboards = createCategory("Motherboards");
        Category memory = createCategory("Memory");
        Category storage = createCategory("Storage");
        Category powerSupplies = createCategory("Power Supplies");
        Category cases = createCategory("PC Cases");
        Category cooling = createCategory("Cooling");
        Category peripherals = createCategory("Peripherals");

        // =========================
        // Processors
        // =========================

        createProduct(
                "AMD Ryzen 7 7800X3D",
                "High-performance gaming processor with 8 cores and 16 threads.",
                new BigDecimal("349.99"),
                processors
        );

        createProduct(
                "Intel Core i7-14700K",
                "Powerful 20-core processor designed for gaming and productivity.",
                new BigDecimal("399.99"),
                processors
        );

        createProduct(
                "AMD Ryzen 5 7600X",
                "6-core gaming processor offering excellent performance and efficiency.",
                new BigDecimal("229.99"),
                processors
        );

        // =========================
        // Graphics Cards
        // =========================

        createProduct(
                "NVIDIA GeForce RTX 4070 SUPER",
                "High-performance graphics card for 1440p gaming and creative workloads.",
                new BigDecimal("599.99"),
                graphicsCards
        );

        createProduct(
                "NVIDIA GeForce RTX 4060",
                "Efficient graphics card designed for smooth 1080p and 1440p gaming.",
                new BigDecimal("299.99"),
                graphicsCards
        );

        createProduct(
                "AMD Radeon RX 7800 XT",
                "Powerful 16GB graphics card built for high-quality 1440p gaming.",
                new BigDecimal("499.99"),
                graphicsCards
        );

        // =========================
        // Motherboards
        // =========================

        createProduct(
                "ASUS ROG STRIX B650-E Gaming",
                "Premium AM5 motherboard with PCIe 5.0 and advanced connectivity.",
                new BigDecimal("279.99"),
                motherboards
        );

        createProduct(
                "MSI MAG B760 Tomahawk WiFi",
                "Reliable Intel motherboard with WiFi and strong VRM cooling.",
                new BigDecimal("189.99"),
                motherboards
        );

        createProduct(
                "Gigabyte B650 AORUS Elite AX",
                "Feature-rich AM5 motherboard supporting DDR5 and PCIe 5.0.",
                new BigDecimal("199.99"),
                motherboards
        );

        // =========================
        // Memory
        // =========================

        createProduct(
                "Corsair Vengeance 32GB DDR5",
                "32GB DDR5 memory kit designed for modern gaming PCs.",
                new BigDecimal("99.99"),
                memory
        );

        createProduct(
                "G.Skill Trident Z5 32GB DDR5",
                "High-speed DDR5 memory with premium performance and RGB lighting.",
                new BigDecimal("119.99"),
                memory
        );

        createProduct(
                "Kingston Fury Beast 16GB DDR5",
                "Reliable 16GB DDR5 memory for gaming and everyday computing.",
                new BigDecimal("54.99"),
                memory
        );

        // =========================
        // Storage
        // =========================

        createProduct(
                "Samsung 990 PRO 1TB NVMe SSD",
                "High-speed PCIe 4.0 NVMe SSD for fast gaming and application loading.",
                new BigDecimal("89.99"),
                storage
        );

        createProduct(
                "WD Black SN850X 2TB NVMe SSD",
                "High-performance 2TB NVMe SSD designed for gaming and demanding workloads.",
                new BigDecimal("149.99"),
                storage
        );

        createProduct(
                "Crucial P3 Plus 1TB NVMe SSD",
                "Affordable PCIe 4.0 NVMe storage for modern desktop systems.",
                new BigDecimal("64.99"),
                storage
        );

        // =========================
        // Power Supplies
        // =========================

        createProduct(
                "Corsair RM850x 850W",
                "Fully modular 850W power supply with high efficiency and reliable performance.",
                new BigDecimal("139.99"),
                powerSupplies
        );

        createProduct(
                "be quiet! Pure Power 12 M 750W",
                "Fully modular ATX 3.0 power supply designed for modern gaming PCs.",
                new BigDecimal("109.99"),
                powerSupplies
        );

        createProduct(
                "MSI MAG A650BN 650W",
                "Affordable 650W power supply suitable for mainstream gaming systems.",
                new BigDecimal("64.99"),
                powerSupplies
        );

        // =========================
        // PC Cases
        // =========================

        createProduct(
                "NZXT H5 Flow",
                "Compact ATX case with excellent airflow and a clean modern design.",
                new BigDecimal("94.99"),
                cases
        );

        createProduct(
                "Lian Li LANCOOL 216",
                "High-airflow gaming case with excellent cooling support.",
                new BigDecimal("109.99"),
                cases
        );

        createProduct(
                "Corsair 4000D Airflow",
                "Popular mid-tower case focused on airflow and easy component installation.",
                new BigDecimal("94.99"),
                cases
        );

        // =========================
        // Cooling
        // =========================

        createProduct(
                "Noctua NH-D15",
                "Premium dual-tower CPU air cooler known for excellent thermal performance.",
                new BigDecimal("119.99"),
                cooling
        );

        createProduct(
                "DeepCool AK620",
                "High-performance dual-tower CPU cooler with efficient heat dissipation.",
                new BigDecimal("64.99"),
                cooling
        );

        createProduct(
                "Corsair iCUE H150i Elite",
                "360mm liquid CPU cooler with advanced cooling and RGB lighting.",
                new BigDecimal("179.99"),
                cooling
        );

        // =========================
        // Peripherals
        // =========================

        createProduct(
                "Logitech G Pro X Superlight 2",
                "Lightweight wireless gaming mouse designed for competitive gaming.",
                new BigDecimal("149.99"),
                peripherals
        );

        createProduct(
                "Keychron K2 Pro",
                "Wireless mechanical keyboard with a compact layout and hot-swappable switches.",
                new BigDecimal("109.99"),
                peripherals
        );

        createProduct(
                "Logitech G Pro X Gaming Headset",
                "Gaming headset with clear audio and a professional-grade microphone.",
                new BigDecimal("129.99"),
                peripherals
        );

        System.out.println("Hardware seed data inserted successfully!");
    }

    private Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    private void createProduct(
            String name,
            String description,
            BigDecimal price,
            Category category
    ) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);

        productRepository.save(product);
    }
}