package tn.esprit.spring.entity;

import java.util.List;

public class Pagina {

        private List<Professeur> professeurs;
        private List<Departement> departements;

        private int totalPages;
        private int pageNumber;
        private int pageSize;

        public Pagina(){}

        public Pagina(List<Professeur> professeurs, int totalPages,
                      int pageNumber, int pageSize) {
            this.professeurs  = professeurs;
            this.totalPages = totalPages;
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
        }
        public Pagina(List<Departement> departements, int totalPages,
                      int pageNumber, int pageSize,int p) {
            this.departements = departements;
            this.totalPages = totalPages;
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
        }

        public void setContrats(List<Professeur> professeurs) {
            this.professeurs = professeurs;
        }


        public List<Departement> getDepartements() {
            return departements;
        }

        public void setDepartements(List<Departement> departements) {
            this.departements = departements;
        }

        public List<Professeur> getProfesseurs() {
            return professeurs;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalPages() {
            return this.totalPages;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageNumber() {
            return this.pageNumber;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageSize() {
            return this.pageSize;
        }
    }
