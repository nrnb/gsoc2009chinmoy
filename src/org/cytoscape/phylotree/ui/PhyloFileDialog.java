package org.cytoscape.phylotree.ui;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import cytoscape.Cytoscape;
import java.io.File;
import org.cytoscape.phylotree.actions.PhyloTreeImportAction;

public class PhyloFileDialog extends JDialog{

	PhyloTreeImportAction parent;
	File selectedFile = null;
	String format = "phylip"; // default
	
	   /** Creates new form PhyloFileDialog */
    public PhyloFileDialog(PhyloTreeImportAction pParent) {
        super(Cytoscape.getDesktop(), true);
        this.parent = pParent;
        initComponents();
        
        buttonGroup1.add(rbtPhylip);
        buttonGroup1.add(rbtPhyloXML);
        
        this.setTitle("Select Phylogenetic Tree File");
        this.setSize(400,200);
        this.setLocationRelativeTo(Cytoscape.getDesktop());
        this.setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfFileName = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbFormat = new javax.swing.JLabel();
        rbtPhylip = new javax.swing.JRadioButton();
        rbtPhyloXML = new javax.swing.JRadioButton();
        pnlButtons = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel1.setText("Phylogenetic File");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        getContentPane().add(jLabel1, gridBagConstraints);

        tfFileName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(tfFileName, gridBagConstraints);

        btnFile.setText("...");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(btnFile, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbFormat.setText("Format");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel1.add(lbFormat, gridBagConstraints);

        rbtPhylip.setSelected(true);
        rbtPhylip.setText("Phylip");
        rbtPhylip.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rbtPhylip.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel1.add(rbtPhylip, gridBagConstraints);

        rbtPhyloXML.setText("phyloXML");
        rbtPhyloXML.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rbtPhyloXML.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel1.add(rbtPhyloXML, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 20, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        pnlButtons.add(btnOK);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pnlButtons.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 10);
        getContentPane().add(pnlButtons, gridBagConstraints);

        pack();
    }// </editor-fold>                        

    
    
    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
		chooser.setAcceptAllFileFilterUsed(false);
		
		chooser.addChoosableFileFilter(new PhylipFileFilter());
		chooser.addChoosableFileFilter(new PhyloXMLFileFilter());
		
		if(rbtPhyloXML.isSelected())
			chooser.setFileFilter(new PhyloXMLFileFilter());
		else if(rbtPhylip.isSelected())
				chooser.setFileFilter(new PhylipFileFilter());
		
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	selectedFile = chooser.getSelectedFile();
	    	tfFileName.setText(selectedFile.getName());	
	    }
	 
	        
    }                                       

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	this.dispose();
    }                                         

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	if (rbtPhyloXML.isSelected()){
    		this.format = "phyloxml";
    	}
    	else if (rbtPhylip.isSelected()){
    		this.format = "phylip";
    	}
    	
    	this.dispose();
    	
       	parent.ImportTreeFromFile(this.selectedFile, this.format);	
    }                                     

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFormat;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JRadioButton rbtPhylip;
    private javax.swing.JRadioButton rbtPhyloXML;
    private javax.swing.JTextField tfFileName;
    // End of variables declaration                   
    
    
    // Inner classes - file filters for Phylip and phyloxml format
    class PhylipFileFilter extends FileFilter{
    	 //Accept all directories and all gif, jpg, tiff, or png files.
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }

            String extension = getExtension(f);
            if (extension != null) {
                if (extension.equals("nh") || extension.equals("newick") || extension.equals("phy"))
                {
                        return true;
                } 
                else
                {
                    return false;
                }
            }

            return false;
        }

        //The description of this filter
        public String getDescription() {
            return "Newick and Phylip format files";
        }
     	
    }
    
    class PhyloXMLFileFilter extends FileFilter{
   	   public boolean accept(File f) {
           if (f.isDirectory()) {
               return true;
           }

           String extension = getExtension(f);
           if (extension != null) {
               if (extension.equals("phyloxml") || extension.equals("xml"))
               {
                       return true;
               } 
               else
               {
                   return false;
               }
           }

           return false;
       }

       //The description of this filter
       public String getDescription() {
           return "PhyloXML format files";
       }
    	
   }
    
    /*
     * Get the extension of a file.
     */
    public String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}