package uz.imaan;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.imaan.entity.TelegramUser;
import uz.imaan.entity.enums.Role;
import uz.imaan.entity.enums.UserStatus;

import java.util.HashMap;
import java.util.Map;

public class ResumeBot extends TelegramLongPollingBot {

    private final Map<Long, TelegramUser> userDatabase = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            Long chatId = update.getMessage().getChatId();

            String text = update.getMessage().getText();

            TelegramUser user = userDatabase.getOrDefault(chatId, new TelegramUser(chatId));

            if (chatId.equals(8749252482L)){
                user.setRole(Role.ADMIN);
            }

            if(user.getRole() == Role.ADMIN){
                handleAdmin(update, user);
            } else {
                handleUser(update, user);
            }
            userDatabase.put(chatId, user);
        }
    }

    private void handleUser(Update update, TelegramUser user) {
        String text = update.getMessage().getText();
        Long chatId = user.getChatId();

        if(text.equals("/start")){
            user.setStatus(UserStatus.START);
        }

        switch (user.getStatus()){
            case START:
                sendText("Assalomu alaykum! Rezyume botga xush kelibsiz, Iltimos, to'liq ismingizni kiriting.", chatId);

                user.setStatus(UserStatus.ASKING_NAME);
                break;
            case ASKING_NAME:
                user.setFullName(text);
                sendText("Yaxshi, yo'nalishingiz va Tajribangiz haqida qisqacha ma'lumot bering.", chatId);

                user.setStatus(UserStatus.ASKING_EXPERIENCE);
                break;
            case ASKING_EXPERIENCE:
                user.setExprience(text);

                user.setStatus(UserStatus.COMPLETED);

                String msg = "Rahmat malumotingiz qabul qilindi." +
                        " \n\n" + "ism familiya : " + user.getFullName() +
                        "\n" + "tajriba haqida malumotingiz : " + user.getExprience() +
                        "\n\n" + "Adminlar sizga aloqaga chiqishadi";

                String adminMsg = "Yangi ariza keldi \n" +
                        user.getFullName() + "\n" + "Tajriba :  " +  user.getExprience() + "\n" + " id : " + user.getChatId();

                sendText(adminMsg, 8749252482L);
                break;

            case COMPLETED:
                sendText("Sizning arizangiz ko'rib chiqilmoqda",chatId);
                break;

        }
    }

    public void handleAdmin(Update update, TelegramUser admin) {
        sendText("Salom admin mana arizalar", admin.getChatId());
    }

    public void sendText(String text, Long chatId){
        SendMessage sm = new SendMessage();

        sm.setChatId(chatId.toString());
        sm.setText(text);
        try{
            execute(sm);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "";
    }

    public String getBotToken() {
        return "";
    }
}
