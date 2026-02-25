/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

/**
 *
 * @author Chino
 */
public interface IInscripcionSubject {
    void addObserver(IInscripcionObserver obs);
    void removeObserver(IInscripcionObserver obs);
}
