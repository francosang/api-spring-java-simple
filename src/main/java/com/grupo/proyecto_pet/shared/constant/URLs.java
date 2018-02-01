package com.grupo.proyecto_pet.shared.constant;

/**
 * @author Franco on 07/31/2017.
 */
public class URLs {

    public static class Empresa {
        public static final String LISTA =  "empresa/lista";
        public static final String SHOW =   "empresa/detalle";
        public static final String FORM =   "empresa/form";
    }

    public class Local {
        public static final String LISTA =  "local/lista";
        public static final String SHOW =   "local/detalle";
        public static final String FORM =   "local/form";
    }

    public class API {
        public static final String BASE =  "/api";
        public static final String V1 =  "/v1";

        public static final String BASE_V1 =  BASE + V1;
        public static final String EMPRESA_V1 =  BASE + V1 + "/empresa";
        public static final String LOCAL_V1 =  BASE + V1 + "/local";
        public static final String USUARIO_V1 =  BASE + V1 + "/usuario";
    }

}
