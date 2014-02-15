/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.beans.*;

/**
 *
 * @author dobri
 */
public class RadnikBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( ent.Radnik.class , null ); // NOI18N
        beanDescriptor.setHidden ( true );//GEN-HEADEREND:BeanDescriptor

        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor
    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_aktivan = 0;
    private static final int PROPERTY_FKIDOrgjed = 1;
    private static final int PROPERTY_FKIDVrsta = 2;
    private static final int PROPERTY_grupa = 3;
    private static final int PROPERTY_IDRadnik = 4;
    private static final int PROPERTY_ime = 5;
    private static final int PROPERTY_koeficijent = 6;
    private static final int PROPERTY_orgjed = 7;
    private static final int PROPERTY_prezime = 8;
    private static final int PROPERTY_raddanList = 9;
    private static final int PROPERTY_sifraINFSISTEM = 10;
    private static final int PROPERTY_sifraradnikaOLD = 11;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[12];
    
        try {
            properties[PROPERTY_aktivan] = new PropertyDescriptor ( "aktivan", ent.Radnik.class, "getAktivan", null ); // NOI18N
            properties[PROPERTY_aktivan].setDisplayName ( "Radnik Aktivan ?" );
            properties[PROPERTY_FKIDOrgjed] = new PropertyDescriptor ( "FKIDOrgjed", ent.Radnik.class, "getFKIDOrgjed", null ); // NOI18N
            properties[PROPERTY_FKIDOrgjed].setHidden ( true );
            properties[PROPERTY_FKIDVrsta] = new PropertyDescriptor ( "FKIDVrsta", ent.Radnik.class, "getFKIDVrsta", null ); // NOI18N
            properties[PROPERTY_FKIDVrsta].setHidden ( true );
            properties[PROPERTY_grupa] = new PropertyDescriptor ( "grupa", ent.Radnik.class, "getGrupa", null ); // NOI18N
            properties[PROPERTY_grupa].setDisplayName ( "Grupa" );
            properties[PROPERTY_IDRadnik] = new PropertyDescriptor ( "IDRadnik", ent.Radnik.class, "getIDRadnik", null ); // NOI18N
            properties[PROPERTY_IDRadnik].setDisplayName ( "ID Radnika" );
            properties[PROPERTY_ime] = new PropertyDescriptor ( "ime", ent.Radnik.class, "getIme", null ); // NOI18N
            properties[PROPERTY_ime].setDisplayName ( "Ime" );
            properties[PROPERTY_koeficijent] = new PropertyDescriptor ( "koeficijent", ent.Radnik.class, "getKoeficijent", null ); // NOI18N
            properties[PROPERTY_koeficijent].setHidden ( true );
            properties[PROPERTY_orgjed] = new PropertyDescriptor ( "orgjed", ent.Radnik.class, "getOrgjed", null ); // NOI18N
            properties[PROPERTY_orgjed].setHidden ( true );
            properties[PROPERTY_prezime] = new PropertyDescriptor ( "prezime", ent.Radnik.class, "getPrezime", null ); // NOI18N
            properties[PROPERTY_prezime].setDisplayName ( "Prezime" );
            properties[PROPERTY_raddanList] = new PropertyDescriptor ( "raddanList", ent.Radnik.class, "getRaddanList", null ); // NOI18N
            properties[PROPERTY_raddanList].setHidden ( true );
            properties[PROPERTY_sifraINFSISTEM] = new PropertyDescriptor ( "sifraINFSISTEM", ent.Radnik.class, "getSifraINFSISTEM", null ); // NOI18N
            properties[PROPERTY_sifraINFSISTEM].setDisplayName ( "Šifra iz Informacionog Sistema" );
            properties[PROPERTY_sifraradnikaOLD] = new PropertyDescriptor ( "sifraradnikaOLD", ent.Radnik.class, "getSifraradnikaOLD", null ); // NOI18N
            properties[PROPERTY_sifraradnikaOLD].setHidden ( true );
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties

        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties
    // EventSet identifiers//GEN-FIRST:Events

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[0];//GEN-HEADEREND:Events

        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events
    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_equals0 = 0;
    private static final int METHOD_hashCode1 = 1;
    private static final int METHOD_toString2 = 2;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[3];
    
        try {
            methods[METHOD_equals0] = new MethodDescriptor(ent.Radnik.class.getMethod("equals", new Class[] {java.lang.Object.class})); // NOI18N
            methods[METHOD_equals0].setDisplayName ( "" );
            methods[METHOD_hashCode1] = new MethodDescriptor(ent.Radnik.class.getMethod("hashCode", new Class[] {})); // NOI18N
            methods[METHOD_hashCode1].setDisplayName ( "" );
            methods[METHOD_toString2] = new MethodDescriptor(ent.Radnik.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString2].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods

        // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods
    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons
    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx

//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.
//GEN-LAST:Superclass
    /**
     * Gets the bean's
     * <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's
     * <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis. <p> If a property is indexed,
     * then its entry in the result array will belong to the
     * IndexedPropertyDescriptor subclass of PropertyDescriptor. A client of
     * getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's
     * <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's
     * <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors. <P>	Returns -1 if there is no default
     * property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors. <P>	Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats. <p> Beans aren't required to provide
     * icons and may return null from this method. <p> There are four possible
     * flavors of icons (16x16 color, 32x32 color, 16x16 mono, 32x32 mono). If a
     * bean choses to only support a single icon we recommend supporting 16x16
     * color. <p> We recommend that icons have a "transparent" background so
     * they can be rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
}
