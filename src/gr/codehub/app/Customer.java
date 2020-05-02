package gr.codehub.app;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    //fields
    private float id;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private ArrayList<String> addresses = new ArrayList<>();
    private String primaryAddress;
    private int age;
    private String gender;
    private String password;

    //constructors
    public Customer(String name, String surname, String email, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        id = Objects.hash(name, surname, email);
    }

    public Customer(String name, String surname, String email, String password,
                    String tel, int age, String gender){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        id = Objects.hash(name, surname, email);
        this.tel = tel;
        this.age = age;
        this.gender = gender;
    }

    //getter methods, accessors
    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    //setter methods,  mutators, modifiers
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAddress(String address) {
        addresses.add(address);
        primaryAddress = addresses.get(0);
    }

    public void removeAddress(int index) {
        if (index >= 0 && index <= addresses.size()) {
            addresses.remove(index);
            if (addresses.isEmpty())
                primaryAddress = null;
            else
                primaryAddress = addresses.get(0);
        }
        else
            System.out.println("Wrong index: index out of bounds!");
    }

    public void setPrimaryAddress(int index) {
        if (index > 0 && index <= addresses.size()){
            primaryAddress = addresses.get(index);
        }
        else
            System.out.println("Wrong index: index out of bounds!");
    }

    public void clearAddresses(){
        if(!addresses.isEmpty()) {
            addresses.clear();
            primaryAddress = null;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //toString
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", primaryAddress='" + primaryAddress + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Float.compare(customer.id, id) == 0 &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }

    public static Customer createCustomer(){
        Customer Customer;
        String name;
        String surname;
        String tel;
        String email;
        ArrayList<String> addresses = new ArrayList<>();
        String primaryAddress;
        int age;
        String gender;
        String password;
        String choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please, type your name: ");
        name = scanner.next();
        System.out.println("Please, type your surname: ");
        surname = scanner.next();
        System.out.println("Please, type your email: ");
        email = scanner.next();
        System.out.println("Please, type your password: ");
        password = scanner.next();
        System.out.println("Do you want to personalize your account now? (YES/No): ");
        choice = scanner.next();
        if (choice.equalsIgnoreCase("YES")){
            System.out.println("Please, type your telephone number: ");
            tel = scanner.next();
            System.out.println("Please, type your age: ");
            age = scanner.nextInt();
            System.out.println("Please, type your gender: ");
            gender = scanner.next();
            Customer = new Customer(name, surname, email, password, tel, age, gender);
        }
        else{
            Customer = new Customer(name, surname, email, password);
        }

        return Customer;
    }
}
