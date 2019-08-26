package com.haritsdeveloper.recyclerview;

    public class ModelMovie {
        private String id;
        private String judul;
        private String subJudul;
        private int gambar;


        public ModelMovie(String id, String judul, String subJudul, int gambar) {
            this.id = id;
            this.judul = judul;
            this.subJudul = subJudul;
            this.gambar = gambar;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {

            this.id = id;
        }

        public String getJudul() {

            return judul;
        }

        public void setJudul(String judul) {

            this.judul = judul;
        }

        public String getSubJudul() {
            return subJudul;
        }

        public void setSubJudul(String subJudul) {
            this.subJudul = subJudul;
        }

        public int getGambar() {
            return gambar;
        }

        public void setGambar(int gambar) {
            this.gambar = gambar;
        }

    }
