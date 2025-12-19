package com.ehliyet.sinav.config;

import com.ehliyet.sinav.entity.Question;
import com.ehliyet.sinav.entity.User;
import com.ehliyet.sinav.repository.QuestionRepository;
import com.ehliyet.sinav.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        initializeAdminUser();
        initializeSampleQuestions();
    }

    private void initializeAdminUser() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .firstName("Admin")
                    .lastName("User")
                    .email("admin@ehliyet.com")
                    .tcNo("12345678901")
                    .phoneNumber("5551234567")
                    .enabled(true)
                    .roles(Set.of("ROLE_ADMIN"))
                    .build();

            userRepository.save(admin);
            log.info("Admin kullanıcısı oluşturuldu - Username: admin, Password: admin123");
        }

        if (userRepository.findByUsername("user").isEmpty()) {
            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("user123"))
                    .firstName("Test")
                    .lastName("Kullanıcı")
                    .email("user@ehliyet.com")
                    .tcNo("98765432109")
                    .phoneNumber("5559876543")
                    .enabled(true)
                    .roles(Set.of("ROLE_USER"))
                    .build();

            userRepository.save(user);
            log.info("Test kullanıcısı oluşturuldu - Username: user, Password: user123");
        }
    }

    private void initializeSampleQuestions() {
        if (questionRepository.count() > 0) {
            log.info("Sorular zaten mevcut, atlaniyor...");
            return;
        }

        log.info("Örnek sorular oluşturuluyor...");

        // 50 örnek soru ekle
        createQuestion("Kırmızı ışıkta araç ne yapmalıdır?",
                "Hızla geçmelidir", "Durmalı ve yeşil ışığı beklemelidir", 
                "Yavaşça geçebilir", "Korna çalarak geçmelidir", 
                "B", Question.QuestionCategory.TRAFIK_KURALLARI);

        createQuestion("Okul servis araçları durduğunda ne yapılmalıdır?",
                "Hızını azaltmadan devam etmeli", "Korna çalmalı",
                "Durmalı ve öğrencilerin geçmesini beklemeli", "Hızla sollayarak geçmeli",
                "C", Question.QuestionCategory.TRAFIK_KURALLARI);

        createQuestion("Emniyet kemeri kullanımı kimler için zorunludur?",
                "Sadece ön koltukta oturanlar", "Sadece sürücü",
                "Tüm yolcular için zorunludur", "Kimse için zorunlu değil",
                "C", Question.QuestionCategory.TRAFIK_KURALLARI);

        createQuestion("Şehir içinde azami hız sınırı kaç km/s'dir?",
                "30 km/s", "50 km/s", "70 km/s", "90 km/s",
                "B", Question.QuestionCategory.TRAFIK_KURALLARI);

        createQuestion("Kırmızı üçgen işareti neyi belirtir?",
                "Durma yasağı", "Park yasağı", "Tehlike uyarısı", "Geçiş yasağı",
                "C", Question.QuestionCategory.TRAFIK_ISARETLERI);

        createQuestion("Dur işaretinin anlamı nedir?",
                "Yavaşlamak", "Tam durmak ve yol vermek", "Korna çalmak", "Hızlanmak",
                "B", Question.QuestionCategory.TRAFIK_ISARETLERI);

        createQuestion("Sarı sürekli çizgi ne anlama gelir?",
                "Geçilebilir", "Sollama ve geçiş yasaktır", "Park edilebilir", "Yavaşlama zorunluluğu",
                "B", Question.QuestionCategory.TRAFIK_ISARETLERI);

        createQuestion("Kavşaklarda öncelik hakkı kimdedir?",
                "Soldan gelen araçta", "Sağdan gelen araçta", "İlk gelen araçta", "Büyük araçta",
                "B", Question.QuestionCategory.TRAFIK_KURALLARI);

        createQuestion("İlk yardımda ABC kuralı ne anlama gelir?",
                "Ambulans-Bandaj-Cenaze", "Hava yolu-Solunum-Dolaşım",
                "Alarm-Bekleme-Cevap", "Anestezi-Bağlama-Cerrahi",
                "B", Question.QuestionCategory.ILK_YARDIM);

        createQuestion("Kan kaybı durumunda ilk yapılması gereken nedir?",
                "Buz uygulamak", "Baskı ile kanamayı durdurmaya çalışmak",
                "Yaralıyı koşturmak", "Hiçbir şey yapmamak",
                "B", Question.QuestionCategory.ILK_YARDIM);

        // Daha fazla soru ekle
        for (int i = 11; i <= 50; i++) {
            createQuestion(
                    i + ". Örnek trafik sorusu metni - Bu soru test amaçlıdır",
                    "A şıkkı", "B şıkkı (Doğru cevap)", "C şıkkı", "D şıkkı",
                    "B", 
                    i % 5 == 0 ? Question.QuestionCategory.ILK_YARDIM : Question.QuestionCategory.TRAFIK_KURALLARI
            );
        }

        log.info("50 örnek soru başarıyla oluşturuldu!");
    }

    private void createQuestion(String text, String optA, String optB, String optC, 
                                String optD, String correct, Question.QuestionCategory category) {
        Question question = Question.builder()
                .questionText(text)
                .optionA(optA)
                .optionB(optB)
                .optionC(optC)
                .optionD(optD)
                .correctAnswer(correct)
                .category(category)
                .type(Question.QuestionType.TEXT)
                .active(true)
                .difficulty(1)
                .build();

        questionRepository.save(question);
    }
}
