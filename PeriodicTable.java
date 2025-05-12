package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PeriodicTable extends JFrame implements ActionListener {

    private JButton[] elementButtons;

    public PeriodicTable() {
        setTitle("Periodic Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 18,20,20));

        elementButtons = new JButton[118];

        for (int i = 0; i < elementButtons.length; i++) {
            elementButtons[i] = new JButton(getElementSymbol(i + 1));
            elementButtons[i].setToolTipText(getElementName(i + 1));
            elementButtons[i].addActionListener(this);
            add(elementButtons[i]);
        }

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < elementButtons.length; i++) {
            if (e.getSource() == elementButtons[i]) {
                String elementName = getElementName(i + 1);
                String elementSymbol = getElementSymbol(i + 1);
                int atomicNumber = (i+1);
                double atomicMass = getAtomicMass(i+1);
                String group = getGroup(i+1);
                JOptionPane.showMessageDialog(this, 
                    "Element name: " + elementName + "\n" +
                    "Element symbol: " + elementSymbol + "\n"+
                    		"Atomic Number: "+atomicNumber+"\n"+
                    		"Protons: "+atomicNumber +"\n"+
                    		"Electrons: "+atomicNumber +"\n"+
                    		"Nuetrons: "+ (int)(atomicMass-atomicNumber)+"\n"+
                    		"AtomicMass: "+atomicMass+" u "+"\n"+
                    		"Group: "+group
                    		
                    		,
                    "Element Information", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    private String getElementName(int atomicNumber) {
        switch (atomicNumber) {
        case 1: return "Hydrogen";
        case 2: return "Helium";
        case 3: return "Lithium";
        case 4: return "Beryllium";
        case 5: return "Boron";
        case 6: return "Carbon";
        case 7: return "Nitrogen";
        case 8: return "Oxygen";
        case 9: return "Fluorine";
        case 10: return "Neon";
        case 11: return "Sodium";
        case 12: return "Magnesium";
        case 13: return "Aluminum";
        case 14: return "Silicon";
        case 15: return "Phosphorus";
        case 16: return "Sulfur";
        case 17: return "Chlorine";
        case 18: return "Argon";
        case 19: return "Potassium";
        case 20: return "Calcium";
        case 21: return "Scandium";
        case 22: return "Titanium";
        case 23: return "Vanadium";
        case 24: return "Chromium";
        case 25: return "Manganese";
        case 26: return "Iron";
        case 27: return "Cobalt";
        case 28: return "Nickel";
        case 29: return "Copper";
        case 30: return "Zinc";
        case 31: return "Gallium";
        case 32: return "Germanium";
        case 33: return "Arsenic";
        case 34: return "Selenium";
        case 35: return "Bromine";
        case 36: return "Krypton";
        case 37: return "Rubidium";
        case 38: return "Strontium";
        case 39: return "Yttrium";
        case 40: return "Zirconium";
        case 41: return "Niobium";
        case 42: return "Molybdenum";
        case 43: return "Technetium";
        case 44: return "Ruthenium";
        case 45: return "Rhodium";
        case 46: return "Palladium";
        case 47: return "Silver";
        case 48: return "Cadmium";
        case 49: return "Indium";
        case 50: return "Tin";
        case 51: return "Antimony";
        case 52: return "Tellurium";
        case 53: return "Iodine";
        case 54: return "Xenon";
        case 55: return "Cesium";
        case 56: return "Barium";
        case 57: return "Lanthanum";
        case 58: return "Cerium";
        case 59: return "Praseodymium";
        case 60: return "Neodymium";
        case 61: return "Promethium";
        case 62: return "Samarium";
        case 63: return "Europium";
        case 64: return "Gadolinium";
        case 65: return "Terbium";
        case 66: return "Dysprosium";
        case 67: return "Holmium";
        case 68: return "Erbium";
        case 69: return "Thulium";
        case 70: return "Ytterbium";
        case 71: return "Lutetium";
        case 72: return "Hafnium";
        case 73: return "Tantalum";
        case 74: return "Tungsten";
        case 75: return "Rhenium";
        case 76: return "Osmium";
        case 77: return "Iridium";
        case 78: return "Platinum";
        case 79: return "Gold";
        case 80: return "Mercury";
        case 81: return "Thallium";
        case 82: return "Lead";
        case 83: return "Bismuth";
        case 84: return "Polonium";
        case 85: return "Astatine";
        case 86: return "Radon";
        case 87: return "Francium";
        case 88: return "Radium";
        case 89: return "Actinium";
        case 90: return "thorium";
        case 91: return "Protactinium";
        case 92: return "Uranium";
        case 93: return "Neptunium";
        case 94: return "Plutonium";
        case 95: return "Americium";
        case 96: return "Curium";
        case 97: return "Berkelium";
        case 98: return "Californium";
        case 99: return "Einsteinium";
        case 100: return "Fermium";
        case 101: return "Mendelevium";
        case 102: return "Nobelium";
        case 103: return "Lawrencium";
        case 104: return "Rutherfordium";
        case 105: return "Dubnium";
        case 106: return "Seaborgium";
        case 107: return "Bohrium";
        case 108: return "Hassium";
        case 109: return "Meitnerium";
        case 110: return "Darmstadtium";
        case 111: return "Roentgenium";
        case 112: return "Copernicium";
        case 113: return "Nihonium";
        case 114: return "Flerovium";
        case 115: return "Moscovium";
        case 116: return "Livermorium";
        case 117: return "Tennessine";
        case 118: return "Oganesson";
        default: return "Unknown";
        }
    }
    
    private String getElementSymbol(int atomicNumber) {
        switch (atomicNumber) {
        case 1:  return "H";
        case 2:  return "He";
        case 3:  return "Li";
        case 4:  return "Be";
        case 5:  return "B";
        case 6:  return "C";
        case 7:  return "N";
        case 8:  return "O";
        case 9:  return "F";
        case 10: return "Ne";
        case 11: return "Na";
        case 12: return "Mg";
        case 13: return "Al";
        case 14: return "Si";
        case 15: return "P";
        case 16: return "S";
        case 17: return "Cl";
        case 18: return "Ar";
        case 19: return "K";
        case 20: return "Ca";
        case 21: return "Sc";
        case 22: return "Ti";
        case 23: return "V";
        case 24: return "Cr";
        case 25: return "Mn";
        case 26: return "Fe";
        case 27: return "Co";
        case 28: return "Ni";
        case 29: return "Cu";
        case 30: return "Zn";
        case 31: return "Ga";
        case 32: return "Ge";
        case 33: return "As";
        case 34: return "Se";
        case 35: return "Br";
        case 36: return "Kr";
        case 37: return "Rb";
        case 38: return "Sr";
        case 39: return "Y";
        case 40: return "Zr";
        case 41: return "Nb";
        case 42: return "Mo";
        case 43: return "Tc";
        case 44: return "Ru";
        case 45: return "Rh";
        case 46: return "Pd";
        case 47: return "Ag";
        case 48: return "Cd";
        case 49: return "In";
        case 50: return "Sn";
        case 51: return "Sb";
        case 52: return "Te";
        case 53: return "I";
        case 54: return "Xe";
        case 55: return "Cs";
        case 56: return "Ba";
        case 57: return "La";
        case 58: return "Ce";
        case 59: return "Pr";
        case 60: return "Nd";
        case 61: return "Pm";
        case 62: return "Sm";
        case 63: return "Eu";
        case 64: return "Gd";
        case 65: return "Tb";
        case 66: return "Dy";
        case 67: return "Ho";
        case 68: return "Er";
        case 69: return "Tm";
        case 70: return "Yb";
        case 71: return "Lu";
        case 72: return "Hf";
        case 73: return "Ta";
        case 74: return "W";
        case 75: return "Re";
        case 76: return "Os";
        case 77: return "Ir";
        case 78: return "Pt";
        case 79: return "Au";
        case 80: return "Hg";
        case 81: return "Tl";
        case 82: return "Pb";
        case 83: return "Bi";
        case 84: return "Po";
        case 85: return "At";
        case 86: return "Rn";
        case 87: return "Fr";
        case 88: return "Ra";
        case 89: return "Ac";
        case 90: return "Th";
        case 91: return "Pa";
        case 92: return "U";
        case 93: return "Np";
        case 94: return "Pu";
        case 95: return "Am";
        case 96: return "Cm";
        case 97: return "Bk";
        case 98: return "Cf";
        case 99: return "Es";
        case 100: return "Fm";
        case 101: return "Md";
        case 102: return "No";
        case 103: return "Lr";
        case 104: return "Rf";
        case 105: return "Db";
        case 106: return "Sg";
        case 107: return "Bh";
        case 108: return "Hs";
        case 109: return "Mt";
        case 110: return "Ds";
        case 111: return "Rg";
        case 112: return "Cn";
        case 113: return "Nh";
        case 114: return "Fl";
        case 115: return "Mc";
        case 116: return "Lv";
        case 117: return "Ts";
        case 118: return "Og";
        default: return "Unk";
        }
    }
    public String getGroup(int atomicNumber) {
      
    	  if (atomicNumber == 3 || atomicNumber == 11 || atomicNumber == 19 || atomicNumber == 37 || atomicNumber == 55 || atomicNumber == 87) {
    	        return "Alkali metals";
    	    } else if (atomicNumber == 4 || atomicNumber == 12 || atomicNumber == 20 || atomicNumber == 38 || atomicNumber == 56 || atomicNumber == 88) {
    	        return "Alkaline earth metals";
    	    } else if (atomicNumber == 21 || atomicNumber == 22 || atomicNumber == 23 || atomicNumber == 24 || atomicNumber == 25 || atomicNumber == 26 || atomicNumber == 27 || atomicNumber == 28 || atomicNumber == 29 || atomicNumber == 30 || atomicNumber == 39 || atomicNumber == 40 || atomicNumber == 41 || atomicNumber == 42 || atomicNumber == 43 || atomicNumber == 44 || atomicNumber == 45 || atomicNumber == 46 || atomicNumber == 47 || atomicNumber == 48 || atomicNumber == 57 || atomicNumber == 58 || atomicNumber == 59 || atomicNumber == 60 || atomicNumber == 61 || atomicNumber == 62 || atomicNumber == 63 || atomicNumber == 64 || atomicNumber == 65 || atomicNumber == 66 || atomicNumber == 67 || atomicNumber == 68 || atomicNumber == 69 || atomicNumber == 70 || atomicNumber == 71 || atomicNumber == 72 || atomicNumber == 73 || atomicNumber == 74 || atomicNumber == 75 || atomicNumber == 76 || atomicNumber == 77 || atomicNumber == 78 || atomicNumber == 79 || atomicNumber == 80 || atomicNumber == 104 || atomicNumber == 105 || atomicNumber == 106 || atomicNumber == 107 || atomicNumber == 108 || atomicNumber == 109 || atomicNumber == 110 || atomicNumber == 111 || atomicNumber == 112 || atomicNumber == 113 || atomicNumber == 114 || atomicNumber == 115 || atomicNumber == 116 || atomicNumber == 117 || atomicNumber == 118) {
    	        return "Transition metals";
    	    } else if (atomicNumber == 13 || atomicNumber == 31 || atomicNumber == 49 || atomicNumber == 50 || atomicNumber == 81 || atomicNumber == 82 || atomicNumber == 83 || atomicNumber == 84 || atomicNumber == 113 || atomicNumber == 115) {
    	        return "Other metals";
    	    } else if (atomicNumber == 5 || atomicNumber == 14 || atomicNumber == 32 || atomicNumber == 33 || atomicNumber == 51 || atomicNumber == 52 || atomicNumber == 84) {
    	        return "Metalloids";
    	    } else if (atomicNumber == 1 || atomicNumber == 6 || atomicNumber == 7 || atomicNumber == 8 || atomicNumber == 9 || atomicNumber == 15 || atomicNumber == 16 || atomicNumber == 17 || atomicNumber == 34 || atomicNumber == 35 || atomicNumber == 53 || atomicNumber == 85) {
    	        return "Nonmetals";
    	    } else if (atomicNumber == 2 || atomicNumber == 10 || atomicNumber == 18 || atomicNumber == 36 || atomicNumber == 54 || atomicNumber == 86 || atomicNumber == 118) {
    	        return "Noble gases";
    	    } else if (atomicNumber >= 57 && atomicNumber <= 71) {
    	        return "Lanthanides";
    	    } else {
    	        return "Unknown";
    	    }
   
    	     
        }
    


    public double getAtomicMass(int atomicNumber) {
        switch (atomicNumber) {
        case 1: return 1.008;
        case 2: return 4.003;
        case 3: return 6.941;
        case 4: return 9.012;
        case 5: return 10.81;
        case 6: return 12.01;
        case 7: return 14.01;
        case 8: return 16.00;
        case 9: return 19.00;
        case 10: return 20.18;
        case 11: return 22.99;
        case 12: return 24.31;
        case 13: return 26.98;
        case 14: return 28.09;
        case 15: return 30.97;
        case 16: return 32.07;
        case 17: return 35.45;
        case 18: return 39.95;
        case 19: return 39.10;
        case 20: return 40.08;
        case 21: return 44.96;
        case 22: return 47.87;
        case 23: return 50.94;
        case 24: return 52.00;
        case 25: return 54.94;
        case 26: return 55.85;
        case 27: return 58.93;
        case 28: return 58.69;
        case 29: return 63.55;
        case 30: return 65.38;
        case 31: return 69.72;
        case 32: return 72.63;
        case 33: return 74.92;
        case 34: return 78.96;
        case 35: return 79.90;
        case 36: return 83.80;
        case 37: return 85.47;
        case 38: return 87.62;
        case 39: return 88.91;
        case 40: return 91.22;
        case 41: return 92.91;
        case 42: return 95.94;
        case 43: return 98.00;
        case 44: return 101.07;
        case 45: return 102.91;
        case 46: return 106.42;
        case 47: return 107.87;
        case 48: return 112.41;
        case 49: return 114.82;
        case 50: return 118.71;
        case 51: return 121.76;
        case 52: return 127.60;
        case 53: return 126.90;
        case 54: return 131.29;
        case 55: return 132.91;
        case 56: return 137.33;
        case 57: return 138.91;
        case 58: return 140.12;
        case 59: return 140.91;
        case 60: return 144.24;
        case 61: return 145.00;
        case 62: return 150.36;
        case 63: return 151.96;
        case 64: return 157.25;
        case 65: return 158.93;
        case 66: return 162.50;
        case 67: return 164.93032;
        case 68: return 167.259;
        case 69: return 168.93421;
        case 70: return 173.054;
        case 71: return 174.9668;
        case 72: return 178.49;
        case 73: return 180.94788;
        case 74: return 183.84;
        case 75: return 186.207;
        case 76: return 190.23;
        case 77: return 192.217;
        case 78: return 195.084;
        case 79: return 196.966569;
        case 80: return 200.592;
        case 81: return 204.38;
        case 82: return 207.2;
        case 83: return 208.9804;
        case 84: return 209.0;
        case 85: return 210.0;
        case 86: return 222.0;
        case 87: return 223.0;
        case 88: return 226.0;
        case 89: return 227.0;
        case 90: return 232.0377;
        case 91: return 231.03588;
        case 92: return 238.02891;
        case 93: return 237.05;
        case 94: return 244.06;
        case 95: return 243.0614;
        case 96: return 247.0703;
        case 97: return 247.0703;
        case 98: return 251.0796;
        case 99: return 252.0829;
        case 100: return 257.0951;
        case 101: return 258.0986;
        case 102: return 259.101;
        case 103: return 262.11;
        case 104: return 267.121;
        case 105: return 270.13;
        case 106: return 271.135;
        case 107: return 270;
        case 108: return 277;
        case 109: return 284;
        case 110: return 289;
        case 111: return 288;
        case 112: return 293;
        case 113: return 294;
        case 114: return 294;
        case 115: return 295;
        case 116: return 294;
        case 117: return 303;
        case 118: return 305;
        default: return 0.0;
        }
    }

  

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();
        table.setVisible(true);
    }
}
