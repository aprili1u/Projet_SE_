import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQ  {
        private int size;
        public Paquet[] queue;

        public PriorityQ(int capacity) {
            this.size = 0;
            this.queue = new Paquet[capacity];

        }

        public boolean insertElement(Paquet e) {
            Paquet[] temp = new Paquet[this.size];
            if(this.size == this.queue.length) {
                System.arraycopy(this.queue, 0, temp, 0, this.size);
                this.queue = new Paquet[this.size*2];
                if (this.size >= 0) System.arraycopy(temp, 0, this.queue, 0, this.size);
            }
            int i = this.size;
            this.size++;
            while(i>0 && this.queue[(i-1)/2].getPriority() < e.getPriority()) {
                this.queue[i] = this.queue[(i-1)/2];
                i = (i-1)/2;
            }
            this.queue[i]=e;
            return true;
        }

        public Paquet popElement() {
            if(isEmpty()) {
                return null;
            }
            if(size == 1) {
                Paquet save = this.queue[0];
                this.queue[0] = null;
                this.size--;
                return save;
            }
            this.size--;
            Paquet save  = this.queue[0];
            this.queue[0] = this.queue[this.size];
            Paquet x = this.queue[this.size];
            this.queue[this.size] = null;
            int i = 0;
            while (2*i + 1 < this.size) {
                int j = 2*i + 1;
                if (j + 1 < this.size && this.queue[j+1].getPriority() > this.queue[j].getPriority())
                    ++j;
                if (x.getPriority() >= this.queue[j].getPriority()) break;
                this.queue[i] = this.queue[j];
                i = j;
            }
            this.queue[i] = x;
            return save;
        }

        public boolean isEmpty() {
            return this.size == 0;
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

