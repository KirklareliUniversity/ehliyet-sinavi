package com.ehliyet.sinav.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Kullanıcı adı boş olamaz")
    @Size(min = 3, max = 50, message = "Kullanıcı adı 3-50 karakter arası olmalıdır")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Şifre boş olamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Ad boş olamaz")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz")
    @Column(nullable = false)
    private String lastName;

    @Email(message = "Geçerli bir email giriniz")
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String tcNo;

    private String phoneNumber;

    @Column(nullable = false)
    @Builder.Default
    private Boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Builder.Default
    private Set<String> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<ExamResult> examResults = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public boolean isAdmin() {
        return roles.contains("ROLE_ADMIN");
    }

    public boolean isUser() {
        return roles.contains("ROLE_USER");
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
