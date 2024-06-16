package com.itfactory.project.user_service.console_ui;


import com.itfactory.project.user_service.dto.User;

public class EditUserController {
    public static User readNewUser() {
        System.out.println("Enter details to create new user : ");
        String name = MenuUtil.readString("Name: ", false);
        String surname = MenuUtil.readString("Surname: ", false);
        String email = MenuUtil.readString("Email: ", false);
        int age = MenuUtil.readInt("Age: ");
        return new User(name, surname, email, age);
    }

    public static User readUserForUpdate(User user,long id) {
        System.out.println("Introduceti datele pentru a modifica userul cu id-ul = "+ id+" : ");
        String numeIntrodus = MenuUtil.readString("Introduceti numele sau enter pentru a pastra valoarea existenta: ", true);
        String prenumaIntrodus = MenuUtil.readString("Introduceti prenumele sau enter pentru a pastra valoarea existenta: ", true);
        String emailIntrodus = MenuUtil.readString("Introduceti email-ul sau enter pentru a pastra valoarea existenta: ", true);
        int varstaIntrodusa = MenuUtil.readInt("Introduceti varsta sau enter pentru a pastra valoarea existenta: ");
        numeIntrodus = "".equals(numeIntrodus) ? user.getName():numeIntrodus;
        prenumaIntrodus = "".equals(prenumaIntrodus)? user.getSurname():prenumaIntrodus;
        emailIntrodus = "".equals(emailIntrodus)? user.getEmail(): emailIntrodus;
        varstaIntrodusa = 0==varstaIntrodusa? user.getAge():varstaIntrodusa;
        return new User(id, numeIntrodus, prenumaIntrodus, emailIntrodus, varstaIntrodusa);
    }
}
