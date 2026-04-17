package uz.imaan.entity;

import uz.imaan.entity.enums.Role;
import uz.imaan.entity.enums.UserStatus;

import java.time.LocalDateTime;

public class TelegramUser {
    private Long chatId;
    private String fullName;
    private String exprience;
    private UserStatus userStatus;
    private Role role;
    private UserStatus status;
    private LocalDateTime createdAt;



    public TelegramUser(Long chatId) {
        this.chatId = chatId;
        this.role = Role.USER;
        this.status = UserStatus.START;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getExprience() {
        return exprience;
    }

    public void setExprience(String exprience) {
        this.exprience = exprience;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
