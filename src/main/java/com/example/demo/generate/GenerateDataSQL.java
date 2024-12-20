package com.example.demo.generate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateDataSQL {
    public static void main(String[] args) {
        // Array of businesses with names and descriptions
        String[][] businesses = {
                {"TechNova Solutions", "A cutting-edge technology company specializing in innovative software solutions."},
                {"GreenEarth Landscaping", "Providing eco-friendly landscaping services to create beautiful outdoor spaces."},
                {"Swift Courier Services", "Fast and reliable courier services for businesses and individuals."},
                {"Golden Spoon Catering", "Delicious catering services for weddings, parties, and corporate events."},
                {"Urban Chic Boutique", "Trendy clothing and accessories for the modern fashion enthusiast."},
                {"Silverline Financial", "Offering expert financial planning and investment management services."},
                {"PureGlow Cosmetics", "High-quality skincare and beauty products for radiant skin."},
                {"Sunrise Fitness Studio", "A community-focused fitness center with state-of-the-art equipment."},
                {"BlueWave Consulting", "Providing strategic business consulting and growth solutions."},
                {"Sparkle Cleaning Services", "Affordable and thorough residential and commercial cleaning services."},
                {"EcoEnergy Systems", "Renewable energy solutions for a sustainable future."},
                {"Bright Minds Academy", "A private educational institution focusing on STEM subjects."},
                {"Apex Auto Repairs", "Comprehensive auto repair services with a focus on customer satisfaction."},
                {"Harmony Yoga Studio", "A tranquil space for yoga, meditation, and mindfulness practices."},
                {"ChocoDelight Confectionery", "Handmade chocolates and desserts for every occasion."},
                {"Elite Event Planners", "Professional event planning and management for memorable experiences."},
                {"Timeless Treasures Antiques", "Unique antique items and vintage collectibles for enthusiasts."},
                {"OceanBreeze Travel Agency", "Tailored travel planning for exotic vacations and business trips."},
                {"FreshHarvest Grocers", "Organic and locally sourced grocery items for healthy living."},
                {"Golden Horizon Realtors", "Connecting buyers and sellers in the real estate market."},
                {"SmartTech Gadgets", "Retailing the latest tech gadgets and accessories."},
                {"Majestic Pet Care", "Grooming and care services for beloved pets."},
                {"Fusion Arts Gallery", "Exhibiting contemporary art from emerging and established artists."},
                {"Urban Brew Coffee", "A cozy coffee shop offering premium coffee and baked goods."},
                {"Adventure Seekers Gear", "Outdoor and adventure gear for thrill-seekers."},
                {"Radiant Dental Care", "Comprehensive dental services for the whole family."},
                {"Vivid Vision Photography", "Capturing life's special moments with professional photography."},
                {"NextGen Robotics", "Developing cutting-edge robotic solutions for various industries."},
                {"Summit Peak Hiking Tours", "Guided hiking tours to breathtaking locations."},
                {"Blissful Spa Retreat", "Relaxing spa treatments for rejuvenation and wellness."},
                {"Legacy Custom Furniture", "Bespoke furniture pieces designed to last a lifetime."},
                {"TrueTaste Catering", "Personalized catering for intimate and large-scale events."},
                {"Quantum IT Solutions", "Expert IT support and technology consulting services."},
                {"Happy Paws Veterinary Clinic", "Caring and compassionate veterinary services for pets."},
                {"Vibrant Wellness Center", "Holistic wellness programs for mind and body balance."},
                {"Infinity Motors", "Luxury and performance vehicle sales and services."},
                {"Pristine Pools & Spas", "Professional pool and spa installation and maintenance."},
                {"Celestial Jewelry", "Handcrafted fine jewelry with a celestial touch."},
                {"Bright Start Daycare", "Nurturing care and education for young children."},
                {"Momentum Fitness Gear", "High-performance fitness equipment and accessories."},
                {"CityLink Transportation", "Reliable public and private transportation services."},
                {"Taste of Tuscany", "Authentic Italian cuisine in a family-friendly atmosphere."},
                {"Dynamic Digital Marketing", "Innovative online marketing strategies for businesses."},
                {"Emerald Isle Resorts", "Luxury resort accommodations in scenic locations."},
                {"Epic Games & Comics", "A haven for gamers and comic book enthusiasts."},
                {"Crisp Air HVAC", "Heating, ventilation, and air conditioning solutions."},
                {"Vista Landscaping Co.", "Designing and maintaining stunning landscapes."},
                {"ProActive Security Systems", "Comprehensive security solutions for homes and businesses."},
                {"Luxe Hair Studio", "High-end salon services for hair and beauty."},
                {"Streamline Logistics", "Efficient logistics and supply chain management."},
                {"Artisan Bakehouse", "Freshly baked bread and pastries made with love."},
                {"Crystal Clear Optics", "Precision eyewear and eye care services."},
                {"Urban Roots Farm", "A sustainable urban farm providing fresh produce."},
                {"Creative Spark Designs", "Graphic design and branding services for businesses."},
                {"Unity Health Clinics", "Accessible healthcare services for the community."},
                {"Astro Innovations", "Innovative aerospace technologies and solutions."},
                {"Bella Flora Design", "Beautiful floral arrangements for all occasions."},
                {"Venture Capital Partners", "Funding and mentorship for promising startups."},
                {"Golden Glow Tanning", "Safe and natural-looking tanning services."},
                {"Epicurean Delights", "Gourmet food and catering for special occasions."},
                {"Starline Limousines", "Luxury transportation services for events and travel."},
                {"PrimeTime Fitness", "24/7 fitness center with expert trainers."},
                {"GreenGuard Pest Control", "Effective pest management solutions."},
                {"Bright Future Tutoring", "Personalized academic tutoring for students."},
                {"Radiant Skin Clinic", "Advanced dermatological treatments for healthy skin."},
                {"TechSavvy Repair", "Quick and affordable tech device repairs."},
                {"Seaside Sweets", "Homemade candies and treats by the sea."},
                {"Brilliant Minds Academy", "Innovative education programs for children."},
                {"TopGear Cycle Shop", "Bicycles, accessories, and repair services."},
                {"Fusion Dance Academy", "Dance classes for all ages and skill levels."},
                {"TrueCare Pharmacy", "Personalized pharmacy services and health advice."},
                {"Vitality Nutrition", "Supplements and health foods for active lifestyles."},
                {"PerfectPrint Solutions", "High-quality printing and marketing materials."},
                {"OceanView Marina", "Full-service marina for boating enthusiasts."},
                {"NextWave Technologies", "Innovative solutions in renewable energy."},
                {"Blissful Moments Photography", "Specializing in wedding and portrait photography."},
                {"Summit Software", "Custom software development for businesses."},
                {"Elite Performance Auto", "Specialized auto tuning and performance upgrades."},
                {"Evergreen Homes", "Sustainable and affordable housing solutions."},
                {"Golden Years Senior Care", "Compassionate care for the elderly."},
                {"Creative Craft Studio", "Workshops and supplies for arts and crafts."},
                {"Starlight Bookstore", "A cozy bookstore with a wide range of titles."},
                {"OceanBlue Seafood Grill", "Fresh and flavorful seafood dishes."},
                {"Rapid Response Medical", "Emergency medical supplies and training."},
                {"Urban Bloom Florists", "Beautiful floral designs for all events."},
                {"Aspire Coaching Group", "Professional life and business coaching services."},
                {"SilverLine Accounting", "Accurate and reliable accounting services."},
                {"Golden Leaf Spa", "Relaxing spa treatments in a serene environment."},
                {"Epic Treks Adventures", "Thrilling outdoor adventure experiences."},
                {"Fresh Horizons Bakery", "Artisan breads and pastries made fresh daily."},
                {"Sunshine Solar Co.", "Affordable and efficient solar power solutions."},
                {"GreenThumb Nurseries", "Premium plants and gardening supplies."},
                {"Coastal Breeze Hotels", "Comfortable and luxurious hotel stays."},
                {"BrightPath Education", "Comprehensive tutoring and learning programs."},
                {"Summit Adventure Gear", "Outdoor equipment for the adventurer in you."},
                {"Harmony Home Decor", "Stylish and sustainable home decor items."},
                {"Fresh Catch Seafood", "Supplying fresh seafood to restaurants and homes."},
                {"BlueSkies Aviation", "Private and commercial flight training."},
                {"Peak Performance Coaching", "Personal and professional growth coaching."},
                {"EcoGrow Solutions", "Sustainable agricultural technologies."},
                {"Spark Innovators Lab", "Fostering innovation and entrepreneurial growth."},
                {"Dynamic Web Creations", "Custom web design and development services."},
                {"Golden Fields Vineyard", "Producing fine wines from premium grapes."},
                {"NextLevel Training", "Professional skills training for career growth."},
                {"Urban Cycle Studio", "Indoor cycling classes for fitness enthusiasts."},
                {"Crystal Waters Resorts", "Exclusive vacation destinations with premium amenities."},
                {"VitalEdge Supplements", "High-quality vitamins and supplements."},
                {"Apex Legal Advisors", "Expert legal services and consultations."},
                {"Bright Horizon Learning", "Early childhood education with a focus on creativity."},
                {"Summit Construction Co.", "Reliable and innovative construction solutions."},
                {"StarGaze Observatory", "Exploring the universe through astronomy."},
                {"DreamWorks Architecture", "Designing functional and inspiring buildings."},
                {"Golden Gate Tours", "Guided tours of iconic destinations."},
                {"Infinite Horizons Travel", "Curating unforgettable travel experiences."},
                {"SilverLine Security", "Advanced security systems and monitoring."},
                {"Harmony Wellness Spa", "Relaxing spa treatments for mind and body harmony."},
                {"TopTier Training", "Specialized training programs for professionals."}
        };

        // Adjust the ranges for random values here
        int minCost = 50;
        int maxCost = 500;
        int minTotalStock = 1000;
        int maxTotalStock = 5000;
        int minOwned = 0;
        int maxOwned = 0;

        Random random = new Random();

        String filePath = "src/main/resources/data.sql";

        try (FileWriter writer = new FileWriter(filePath)) {
            int id = 1; // Starting ID value
//            for (String[] business : businesses) {
            for (int i = 0; i < 20; i++) {
                String[] business = businesses[i];
                int cost = random.nextInt(maxCost - minCost + 1) + minCost;
                int totalStock = random.nextInt(maxTotalStock - minTotalStock + 1) + minTotalStock;
                int owned = random.nextInt(maxOwned - minOwned + 1) + minOwned;

                String sql = String.format(
                        "INSERT INTO Record (id, name, description, cost, total_Stock, owned) VALUES (%d, '%s', '%s', %d, %d, %d);",
                        id, business[0].replace("'", "''"), business[1].replace("'", "''"), cost, totalStock, owned
                );

                writer.write(sql + "\n");
                id++;
            }
            System.out.println("data.sql file generated successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
