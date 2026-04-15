package uz.imaan.entity;

import uz.imaan.entity.enums.Role;
import uz.imaan.entity.enums.UserStatus;

public class TelegramUser {
    private Long chatId;
    private String fullName;
    private String exprience;
    private UserStatus userStatus;
    private Role role;
    private UserStatus status;

    public TelegramUser(Long chatId) {
        this.chatId = chatId;
        this.role = Role.USER;
        this.status = UserStatus.START;
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
