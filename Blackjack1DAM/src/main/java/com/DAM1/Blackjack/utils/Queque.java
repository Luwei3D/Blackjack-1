package com.DAM1.Blackjack.utils;
import java.util.ArrayList;

    public class Queque<K> {
        private ArrayList<K> arrayList;

        public Queque(int capacity) {
            this.arrayList = new ArrayList<>(capacity);
        }
    
        public Queque() {
            this(5);
        }
    
        /**
         * Añadimos un elemento a la cola
         * @param e
         * @return True si se ha añadido y false si no se ha añadido
         */
    
        public boolean add(K e) {
            return arrayList.add(e);
        }
    
        /**
         * Elimina el primero que se ha metido dentro del array
         * @return
         */
        
        public K remove() {
            return arrayList.remove(0);
        }
    
        /**
         * Indica el tamaño de la cola
         * @return
         */
    
        public int size() {
            return arrayList.size()-1;
        }
    
        /**
         * Consulta el primer elemento que se mete denro de la cola
         * @return
         */
    
        public K peek() {
            return arrayList.get(0);
        }
    
        /**
         * Indica si esta vacío la cola
         * @return
         */
        
        public boolean isEmpty() {
            return arrayList.size() == 0;
        }
    }

