package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.DatabaseSystem.DeleteFunctions;
import BrainBank.DatabaseSystem.InsertFunctions;
import BrainBank.DatabaseSystem.ReadFunctions;
import BrainBank.DatabaseSystem.UpdateFunctions;
import BrainBank.Files.ReaderClass;
import BrainBank.Files.WriterClass;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.CurrencyExchange;
import BrainBank.ServiceSystem.Loan;
import BrainBank.ServiceSystem.Services;
import BrainBank.ServiceSystem.Transaction;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sun.security.ntlm.Client;

import java.io.Reader;
import java.io.Writer;
import java.util.*;

class SortByName implements Comparator<Bank> {

    public int compare(Bank a, Bank b) {
        return a.getTitle().compareTo(b.getTitle());
    }

}


public class Main {

    private static void menuOutput() {
        System.out.println("\n\n\nBine ati venit!\n\n");
        System.out.println(" 1. Afisati din baza de date");
        System.out.println(" 2. Introduceti in baza de date");
        System.out.println(" 3. Modificati in baza de date");
        System.out.println(" 4. Stergeti din baza de date");
    }

    private static void DatabaseOutput(ArrayList<IndividualClient> clientList, ArrayList<Bank> bankList, ReadFunctions read) {
        bankList.clear();
        clientList.clear();
        read.readBank(bankList);
        read.readClient(clientList);
        read.readCard(clientList);
        read.readCurrentAccount(clientList);
        read.readSavingsAccount(clientList);
        System.out.println("\nBanci: \n");
        System.out.println(bankList);
        System.out.println("\nlienti, carduri, conturi: \n");
        System.out.println(clientList);
    }


    private static void InsertMenu(InsertFunctions ins, Scanner scanner) {
        System.out.println("\n\nCe doriti sa introduceti?\n");
        int op;
        System.out.println(" 1. Banca\n");
        System.out.println(" 2. Client\n");
        op = scanner.nextInt();
        scanner.nextLine();
        if(op == 1)
        {
            String title;
            String address;
            System.out.println("Introduceti titlul bancii: ");
            title = scanner.nextLine();
            System.out.println("Introduceti adresa bancii: ");
            address = scanner.nextLine();
            ins.InsertBank(new Bank(title,address));
        }
        else if(op==2)
        {
            String CNP;
            String last_name;
            String first_name;
            int age;
            System.out.println("Introduceti CNP");
            CNP = scanner.nextLine();
            System.out.println("Introduceti nume: ");
            last_name = scanner.nextLine();
            System.out.println("Introduceti prenume: ");
            first_name = scanner.nextLine();
            System.out.println("Varsta: ");
            age = scanner.nextInt();
            scanner.nextLine();
            ins.InsertClient(new IndividualClient(CNP,last_name,first_name,age));
        }
    }

    private static void UpdateMenu(ArrayList<Bank> bankList, UpdateFunctions update, Scanner scanner) {
        int op;
        System.out.println("\n\nCe doriti sa actualizati?");
        System.out.println("\n 1. Titlul unei banci");
        op = scanner.nextInt();
        scanner.nextLine();
        if(op == 1)
        {
            int idx;
            System.out.println("Care banca?(index)");
            idx = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Titlul nou: ");
            String newTitle;
            newTitle = scanner.nextLine();
            update.updateBankTitle(bankList.get(idx),newTitle);
        }
    }

    private static void DeleteMenu(ArrayList<IndividualClient> clientList, ArrayList<Bank> bankList, DeleteFunctions delete, Scanner scanner) {
        int op;
        System.out.println("Ce doriti sa eliminati?");
        System.out.println(" 1. O banca");
        System.out.println(" 2. Un client");
        op = scanner.nextInt();
        scanner.nextLine();
        if(op == 1)
        {
            int idx;
            System.out.println("Care banca?(index)");
            idx = scanner.nextInt();
            scanner.nextLine();
            delete.deleteBank(bankList.get(idx));
        }
        else if(op == 2)
        {
            int idx;
            System.out.println("Care client?(index)");
            idx = scanner.nextInt();
            scanner.nextLine();
            delete.deleteClient(clientList.get(idx));
        }
    }


    public static void main(String[] args) throws Exception {

        ArrayList<IndividualClient> clientList = new ArrayList<IndividualClient>();
        ArrayList<Bank> bankList = new ArrayList<Bank>();


        InsertFunctions ins = new InsertFunctions();
        ReadFunctions read = new ReadFunctions();
        DeleteFunctions delete = new DeleteFunctions();
        UpdateFunctions update = new UpdateFunctions();
        boolean ok = true;
        while (ok) {
            int option;
            Scanner scanner = new Scanner(System.in);
            menuOutput();
            option = scanner.nextInt();
            if (option == 1) {
                DatabaseOutput(clientList, bankList, read);
            } else if (option == 2) {
                InsertMenu(ins, scanner);
            }
            else if (option == 3) {
                UpdateMenu(bankList, update, scanner);
            }
            else if (option == 4) {
                DeleteMenu(clientList, bankList, delete, scanner);
            }

        }


    }

}
