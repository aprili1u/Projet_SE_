import java.util.Arrays;
import java.util.NoSuchElementException;
public class PriorityQ  {
        private int size;
        public Paquet[] queue;

        public PriorityQ(int capacity) {
            this.size =0;
            this.queue = new Paquet[capacity];

        }

        public boolean insertElement(Paquet e) {
            Paquet[] temp = new Paquet[this.size] ;
            if(this.size == this.queue.length) {
                for(int j=0;j<this.size;j++) {
                    temp[j] = this.queue[j];
                }
                this.queue = new Paquet[this.size*2];
                for(int j=0;j<this.size;j++) {
                    this.queue[j] = temp[j];
                }
            }
            Integer i= this.size;
            this.size++;
            while(i>0 && this.queue[(i-1)/2].getPriority() < e.getPriority()) {
                this.queue[i] = this.queue[(i-1)/2];
                i = (i-1)/2;
            }
            this.queue[i]=e;


            return true;
        }

        public Paquet popElement() {

            this.size--;
            Paquet save  = this.queue[0];
            this.queue[0] = this.queue[this.size];
            Paquet x = this.queue[0];
            this.queue[this.size]=null;
            Integer i = 0;
            while (2*i + 1 < this.size) {
                Integer j = 2*i + 1;
                if (j + 1 < this.size &&  this.queue[j+1].getPriority() > this.queue[j].getPriority())
                    ++j;
                if (x.getPriority() >= this.queue[j].getPriority()) break;
                this.queue[i] = this.queue[j];
                i = j;
            }
            this.queue[i] = x;
            return save;
        }




        public boolean isEmpty() {
            if(this.size == 0) {
                return true;
            }else {
                return false;
            }
        }

        public int size() {
            return this.size;

        }

        public Paquet element() {
            if(this.isEmpty()) {
                throw new NoSuchElementException("la file est vide") ;
            }else {
                return this.queue[0];
            }

        }
        public String toString() {
            return Arrays.toString(this.queue);

        }



}

