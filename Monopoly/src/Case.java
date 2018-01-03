/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BernierCorentin
 */
public abstract class Case {

    public abstract boolean estAchetable();

    public abstract void actionArrive();
}

class CaseProprietes extends Case {

    private Proprietes laPropriete;

    @Override
    public boolean estAchetable() {
        return true;
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CaseParcGratuit extends Case {

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CaseAllezEnPrison extends Case {

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CasePrison extends Case {

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CaseChances extends Case {

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CaseCaisseCommunautaires extends Case {

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CaseTaxes extends Case {

    private String nomCase;
    private int prixTaxe;

    public CaseTaxes(String nomCase, int prixTaxe) {
        this.nomCase = nomCase;
        this.prixTaxe = prixTaxe;
    }

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class CaseDepart extends Case {

    @Override
    public boolean estAchetable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionArrive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
