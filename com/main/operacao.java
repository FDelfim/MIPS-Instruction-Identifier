package com.main;

public class operacao {
    
    private String operacao;
    private String variaveis[];
    
    public operacao(String operacao, String variaveis){
        this.operacao = operacao;
        this.variaveis = variaveis.split(",");
    }
    
    public operacao(String operacao){
        this.operacao = operacao;
    }
    
    private String tipoOperacao(){
        if(this.operacao.toLowerCase().contains("memory")){
            return "memory";
        }
        else{
            if(this.operacao.toLowerCase().contains("add"))
            return "adição";
            else if(this.operacao.toLowerCase().contains("sub"))
            return "subtração";
            else if(this.operacao.toLowerCase().contains("lw"))
            return "load word";
            else if(this.operacao.toLowerCase().contains("sw"))
            return "store word";
        }
        return "Operação inválida";
    }
    
    public String operacaoValida(){
        if(tipoOperacao().equals("operação inválida")){
            return "Operação inválida";
        }else{
            if(tipoOperacao().equals("adição") && this.variaveis.length == 3 || tipoOperacao().equals("subtração") && this.variaveis.length == 3){
                for(int i = 0; i < this.variaveis.length; i++){
                    if(!this.variaveis[i].toLowerCase().contains("$s") && !this.variaveis[i].toLowerCase().contains("$t")){
                        return "Operação inválida";
                    }else{
                        if(this.variaveis[i].toLowerCase().contains("$s")){
                            int num = Integer.parseInt(this.variaveis[i].substring(2));
                            if(num < 0 || num > 7){
                                return "Operação inválida";
                            }else{
                                return "Operação válida";
                            }
                        }else{
                            int num = Integer.parseInt(this.variaveis[i].substring(2));
                            if(num < 0 || num > 9){
                                return "Operação inválida";
                            }else{
                                return "Operação válida";
                            }
                        }
                    }
                }    
            }
            if(tipoOperacao().equals("load word") && this.variaveis.length == 2 || tipoOperacao().equals("store word") && this.variaveis.length == 2){
                if(!this.variaveis[0].toLowerCase().toLowerCase().contains("$s") && !this.variaveis[0].toLowerCase().toLowerCase().contains("$t")){
                    return "Operação inválida";
                }else{
                    if(this.variaveis[0].toLowerCase().toLowerCase().contains("$s")){
                        int num = Integer.parseInt(this.variaveis[0].substring(2));
                        if(num < 0 || num > 7){
                            return "Operação inválida";
                        }else{
                            if(this.variaveis[1].toLowerCase().contains("(") && this.variaveis[1].toLowerCase().contains(")")){
                                String var[] = this.variaveis[1].split("\\(");
                                if(var.length == 2){
                                    if(var[0].matches("[0-9]+")){
                                        if(var[1].toLowerCase().toLowerCase().contains("$t")){
                                            int num2 = Integer.parseInt(var[1].substring(2, 3));
                                            if(num2 < 0 || num2 > 9){
                                                return "Operação inválida";
                                            }else{
                                                return "Operação válida";
                                            }
                                        }else{
                                            return "Operação inválida";
                                        }
                                    }else{
                                        return "Operação inválida";
                                    }
                                }else{
                                    return "Operação inválida";
                                }
                            }else if(this.variaveis[1].toLowerCase().contains("(") && this.variaveis[1].toLowerCase().contains(")")){
                                String var[] = this.variaveis[1].split("\\(");
                                if(var.length == 2){
                                    if(var[0].matches("[0-9]+")){
                                        if(var[1].toLowerCase().toLowerCase().contains("$s")){
                                            int num2 = Integer.parseInt(var[1].substring(2, 3));
                                            if(num2 < 0 || num2 > 7){
                                                return "Operação inválida";
                                            }else{
                                                return "Operação válida";
                                            }
                                        }else{
                                            return "Operação inválida";
                                        }
                                    }else{
                                        return "Operação inválida";
                                    }
                                }else{
                                    return "Operação inválida";
                                }
                            }else{
                                return "Operação inválida";
                            }
                        }
                    }else{
                        int num = Integer.parseInt(this.variaveis[0].substring(2));
                        if(num < 0 || num > 9){
                            return "Operação inválida";
                        }else{
                            return "Operação válida";
                        }
                    }
                }
            }
            if(tipoOperacao().equals("memory")){
                if(this.operacao.toLowerCase().contains("memory[")){
                    String var[] = this.operacao.split("\\[");
                    if(var.length == 2){
                        if(var[1].toLowerCase().contains("]")){
                            String var2[] = var[1].split("\\]");
                            if(var2.length == 1){
                                if(var2[0].matches("[0-9]+")){
                                    return "Operação válida";
                                }else{
                                    return "Operação inválida";
                                }
                            }else{
                                return "Operação inválida";
                            }
                        }else{
                            return "Operação inválida";
                        }
                    }else{
                        return "Operação inválida";
                    }
                }else{
                    return "Operação inválida";
                }
            }
            return "Operação inválida";
        }
    }
}


