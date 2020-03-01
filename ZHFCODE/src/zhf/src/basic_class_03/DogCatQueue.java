package zhf.src.basic_class_03;


/**
 * Created by ZHF on 2018/8/17.
 */
public class DogCatQueue {
    public static class Pet{
        private String type;
        public Pet(String type){
            this.type = type;
        }
        public String getPetType(){
            return this.type;
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("Cat");
        }
    }

    public static class Dog extends Pet{
        public Dog(){
            super("Dog");
        }
    }

    public static class PetEnter{
        private Pet pet;
        private int count;
    }

}
