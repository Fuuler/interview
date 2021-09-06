package patterns.generating.FactoryMethod;

/**
 * Диалог на элементах операционной системы.
 */
public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
