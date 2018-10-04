

public class Driver {
    public static abstract class MoodyObject{
        protected abstract String getMood();
        protected abstract void expressFeelings();
        public void queryMood(){
            System.out.println("I feel " + this.getMood() + " today!");
        }
    }

    public static class SadObject extends MoodyObject {
        protected String getMood(){
            return "sad";
        }
        public void expressFeelings(){
            System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep'");
        }

        public String toString(){
            return "Observation: Subject cries a lot";
        }
    }

    public static class HappyObject extends MoodyObject {
        protected String getMood(){
            return "happy";
        }
        public void expressFeelings(){
            System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
        }

        public String toString(){
            return "Observation: Subject laughs a lot";
        }
    }

    public static class PsychiastristObject{
        public void examine(MoodyObject moodyObject){
            moodyObject.queryMood();
        }

        public void observe(MoodyObject moodyObject){
            moodyObject.expressFeelings();
            System.out.println(moodyObject.toString());
        }
    }

    public static void main(String[] args){
        PsychiastristObject psychiastristObject = new PsychiastristObject();

        SadObject sadObject = new SadObject();
        System.out.println("How are you feeling today?");
        psychiastristObject.examine(sadObject);
        psychiastristObject.observe(sadObject);

        System.out.println();

        HappyObject happyObject = new HappyObject();
        System.out.println("How are you feeling today?");
        psychiastristObject.examine(happyObject);
        psychiastristObject.observe(happyObject);
    }
}
