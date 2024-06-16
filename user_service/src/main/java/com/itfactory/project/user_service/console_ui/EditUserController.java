package com.itfactory.project.user_service.console_ui;


import com.itfactory.project.user_service.dto.User;

public class EditUserController {
    public static User readNewUser() {
        System.out.println("Introduceti detaliile pentru userul nou: ");
        String name = MenuUtil.readString("Nume: ", false);
        String surname = MenuUtil.readString("Prenume: ", false);
        String email = MenuUtil.readString("Email: ", false);
        int age = MenuUtil.readInt("Varsta: ", false);
        return new User(name, surname, email, age);
    }

    public static User readUserForUpdate(User user,long id) {
        System.out.println("Introduceti datele pentru a modifica userul cu id-ul = "+ id+" : ");
        String insertedName = MenuUtil.readString("Introduceti numele sau enter pentru a pastra valoarea existenta: ", true);
        String insertedSurname = MenuUtil.readString("Introduceti prenumele sau enter pentru a pastra valoarea existenta: ", true);
        String insertedEmail = MenuUtil.readString("Introduceti email-ul sau enter pentru a pastra valoarea existenta: ", true);
        int insertedAge = MenuUtil.readInt("Introduceti varsta sau enter pentru a pastra valoarea existenta: ",true);
        insertedName = "".equals(insertedName) ? user.getName() : insertedName;
        insertedSurname = "".equals(insertedSurname)? user.getSurname() : insertedSurname;
        insertedEmail = "".equals(insertedEmail)? user.getEmail() : insertedEmail;
        insertedAge = 0 == insertedAge? user.getAge() : insertedAge;
        return new User(id, insertedName, insertedSurname, insertedEmail, insertedAge);
    }
}
