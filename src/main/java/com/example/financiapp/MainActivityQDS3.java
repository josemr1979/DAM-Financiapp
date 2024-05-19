package com.example.financiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityQDS3 extends AppCompatActivity {

    TextView textView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qds3);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        textView16 = findViewById(R.id.textView16);



    }

    public void onClickButton(View view) {
        switch (view.getId()) {
            case R.id.buttonPtmo:
                textView16.setText("Un PRÉSTAMO es un producto financiero que permite a un usuario acceder a una cantidad fija de dinero, con la condición/obligación de devolver esa cantidad más los intereses pactados, en un plazo determinado." +
                        "La devolución se suele realizar mediante cuotas mensuales que se componen de capital (el dinero prestado) e intereses. \n\nExisten distintos tipos de préstamos, aunque los más usuales son estos:" +
                        "\n\n* Préstamo Personal: Es el que se le concede a un usuario sobre la base de la confianza, ya que la garantía es personal. El titular, en todo caso, responde de la devolucióncon todo su patrimonio, tanto presente como futuro." +
                        "Normalmente se solicitan para financiar la adquisición de bienes duraderos (un coche, muebles, etc), pagar un máster, realizar un viaje, etc... Suelen ser más fáciles de obtener que un préstamo hipotecario, aunque resultan más caros por ser de garantía personal." +
                        "Suelen tener una duración no superior a los 8 años (dependerá ésta de la finalidad)" +
                        "\n\n* Préstamo Hipotecario: Es aquel cuyo pago está garantizado por un bien inmueble (Vivienda, terreno, local, etc...). Habitualmente se suelen solicitar para la compra de una vivienda (o terreno o local) o rehabilitarla. En caso de impago el que nos prestó el dinero se hace con la propiedad del bien hipotecado. Lo habitual es que la duración máxima de este tipo de préstamos sea de 30 años" +
                        "\n\nTanto los derechos como las obligaciones del banco y del cliente han de figurar recogidas en el contrato y ambas partes se comprometen a cumplir con lo firmado.");
                textView16.setGravity(Gravity.START | Gravity.TOP | Gravity.END);
                break;
            case R.id.buttonRatio:
                textView16.setText("El ratio de endeudamiento es una medida financiera que se utiliza para evaluar la proporción de deuda en relación con otros aspectos financieros, como los ingresos. Es una herramienta importante para determinar la salud financiera de un individuo y su capacidad para gestionar la deuda.\n" +
                        "\n" +
                        "El ratio de endeudamiento se calcula dividiendo la deuda total del usuario entre los ingresos." +
                        "\n Normalmente este ratio no debe de sobrepasar el 35% o 40%. Esto será determinante para que la entidad bancaria conceda o no una operación de crédito.");
                break;
            case R.id.buttonCapacidad:
                textView16.setText("Si estamos interesados en la contratación de un préstamo, debemos analizar la oferta que nos propongan, compararla con otras del mercado y sopesar nuestras necesidades y posibilidades de afrontar los pagos durante un periodo largo de tiempo." +
                        "\n\nLa CAPACIDAD DE ENDEUDAMIENTO de una persona se refiere a la cantidad de deuda que puede asumir de manera razonable según sus ingresos, gastos y otras obligaciones financieras. Es básicamente la capacidad de una persona para pedir prestado dinero y pagarlo según los términos acordados sin comprometer su estabilidad financiera o verse incomodada por las deudas. " +
                        "Esta capacidad se determina teniendo en cuenta factores como los ingresos regulares, los gastos mensuales, el historial crediticio, la estabilidad laboral y otros compromisos financieros." +
                        "\nEs uno de los factores que suelen tener muy en cuenta las entidades financieras a la hora de conceder crédito." +
                        "\n\nEn otro apartado de la app te presento una herramienta que te puede orientar para ver tu capacidad de endeudamiento");
                break;
            case R.id.buttonCIRBE:
                textView16.setText("La CIRBE es el acrónimo de Central de Información de Riesgos del Banco de España. \nEs una base de datos que recoge la información de los préstamos, créditos (riesgo directo), avales y garantías (riesgo indirecto) que cada entidad declarante mantiene con sus clientes. \nLa CIRBE no es un registro de morosos. " +
                        "\n\nMensualmente y de forma detallada la CIRBE facilita a las entidades declarantes la información de las personas cuyo riesgo acumulado supere los 1.000 euros. Para poder acceder a esta información, las entidades deben recoger el consentimiento expreso de los clientes. Podemos acceder a nivel personal a nuestros datos que figuren en la CIRBE." +
                        "\nCon esta información las entidades conocen los importes que existen de riesgo a nivel global de cada cliente y por rama de producto.");
                break;
            case R.id.buttonComisiones:
                textView16.setText("Las COMISIONES bancarias son tarifas o cargos que las entidades financieras cobran a sus clientes por diversos servicios financieros que ofrecen. Estas comisiones pueden variar dependiendo del banco. \n\nLas comisiones que te puede cobrar una entidad financiera por la solicitud, modificación o cancelación de un préstamo pueden ser las siguientes:" +
                        "\n\n1. Comisión de apertura: algunas entidades pueden aplicar ésta al inicio de un préstamo. Esta comisión se cobra como parte de los costes asociados con el proceso de concesión del préstamo y suele ser un porcentaje del montante total del préstamo. \nEs importante tener en cuenta que no todos los préstamos tienen esta comisión." +
                        "\n\n2. Comisión de estudio: Esta comisión se cobra por los costes asociados con el análisis y la evaluación de la solicitud del préstamo por parte del prestamista (revisión de la documentación proporcionada por el solicitante, la verificación de antecedentes crediticios y financieros, el análisis de la capacidad de pago del solicitante, entre otros). " +
                        "\nEs importante tener en cuenta que no todos los préstamos tienen esta comisión." +
                        "\n\n3. Comisión de novación: Es un cargo que puede aplicar una entidad financiera cuando se realiza una novación (modificación) de un préstamo. La novación es un proceso mediante el cual se modifican las condiciones de un préstamo existente, como el tipo de interés, el plazo de amortización, las garantías, entre otros aspectos. En resumidas cuentas, todo cambio que conlleve la modificación de las condiciones iniciales del préstamo." +
                        "\nEs importante tener en cuenta que no todos los préstamos tienen esta comisión." +
                        "\n\n4. Comisión de cancelación: Es un cargo que puede aplicar una entidad financiera cuando un cliente decide cancelar anticipadamente un préstamo. Esta comisión se cobra como compensación por los intereses futuros que el prestamista dejará de percibir debido a la cancelación anticipada del préstamo.\n" +
                        "\n" +
                        "La comisión de cancelación puede variar según la entidad financiera y el tipo de préstamo del que se trate, y debe estar establecida en el contrato de préstamo. Por lo general, se expresa como un porcentaje del saldo pendiente del préstamo." +
                        "\nEs importante tener en cuenta que no todos los préstamos tienen esta comisión." +
                        "\n\n\nAntes de aceptar un préstamo, es fundamental revisar detenidamente el contrato para comprender todas las tarifas y costes asociados, incluida la comisión de apertura, estudio, novación o cancelación, para así tomar una decisión informada sobre si el préstamo es adecuado para tus necesidades financieras.");
                break;
            case R.id.buttonFinanc:
                textView16.setText("Texto del botón 2");
                break;
            case R.id.buttonEuribor:
                textView16.setText("El EURIBOR (Euro Interbank Offered Rate) es un tipo de interés de referencia que se utiliza en el mercado interbancario de la zona euro. Es el tipo de interés al que los bancos de la eurozona están dispuestos a prestar dinero entre sí en el mercado mayorista. \n" +
                        "\n" +
                        "El EURIBOR es muy utilizado como referencia para una variedad de productos financieros, como los préstamos hipotecarios (tipo de interés variable). Los cambios en el EURIBOR pueden afectar a las cuotas de endeudamiento para los usuarios.\n" +
                        "\n" +
                        "Es importante tener en cuenta que existen varios plazos de EURIBOR, como 1 mes, 3 meses, 6 meses y 12 meses. El que se suele utilizar para las hipotecas es el de 12 meses. \nEn el inicio de la app puedes ver la cotización diaria del EURIBOR.");
                break;
            case R.id.buttonGastos:
                textView16.setText("Texto del botón 2");
                break;
            case R.id.buttonMorosos:
                textView16.setText("Los FICHEROS DE MOROSOS, también conocidos como registros de morosidad o listas de impagos, son bases de datos donde se registran las personas o empresas que tienen deudas impagas con entidades financieras, empresas de servicios (como telecomunicaciones) u otros acreedores. Estos registros son utilizados por las entidades para evaluar el riesgo crediticio de un individuo o una empresa antes de otorgarles crédito o realizar cualquier tipo de transacción financiera." +
                        "\n\nLos ficheros de morosos más conocidos son: \n\n1. ASNEF (Asociación Nacional de Establecimientos Financieros de Crédito): Es uno de los ficheros de morosos más grandes de España. ASNEF registra información sobre deudas impagas relacionadas con créditos al consumo, tarjetas de crédito, préstamos personales, entre otros." +
                        "\n\n2. RAI (Registro de Aceptaciones Impagadas): También presente en España, se enfoca en deudas comerciales entre empresas." +
                        "\n\n3. Equifax (anteriormente conocido como Experian): Es una de las agencias de informes de crédito más grandes del mundo y opera en varios países, incluidos Estados Unidos, Canadá, Reino Unido y Australia." +
                        "\n\n4. Credit Bureau: Este es el término general para agencias de informes de crédito que operan en muchos países, como en Canadá (Equifax y TransUnion), Alemania (Schufa), Francia (Banque de France), entre otros." +
                        "\n\nEstos ficheros de morosos recopilan información sobre las deudas impagas y la mantienen durante un período determinado, lo que puede afectar la capacidad de una persona o empresa para obtener crédito en el futuro si no se resuelven las deudas registradas.");
                break;
            case R.id.buttonTAE:
                textView16.setText("La TASA ANUAL EQUIVALENTE o TAE es un indicador en forma de tanto por ciento anual que sirve para comparar el coste efectivo de dos o más préstamos en un plazo concreto, aunque tengan condiciones diferentes. \n\nLa TAE se expresa en forma de porcentaje" +
                        " y se calcula con una fórmula matemática en base al tipo de interés nominal (TIN) -el precio que nos cobra el banco por prestarnos el dinero-; la frecuencia de las cuotas para devolver el préstamo (mensuales, trimestrales, anuales, etc.); las comisiones bancarias y los gastos de la operación que asume el consumidor." +
                        "\n" +
                        "\nLas entidades financieras usan la Tasa Anual Equivalente (TAE) y el Tipo de Interés Nominal (TIN) para presentar la rentabilidad de las operaciones financieras." +
                        "\n" +
                        "\nLa Tasa Anual Equivalente permite comparar entre múltiples operaciones financieras con períodos de capitalización distintos, usando a una misma base temporal anual. Permite homogeneizar diferentes tipos nominales, gastos, comisiones, periodos de liquidación, etc."+
                        "\n\nHistoria de la Tasa anual equivalente\n" +
                        "\n\nLa Tasa anual equivalente fue creada en 1985 por el ingeniero, matemático y especialista en análisis numérico José Luis Andrés Yebra ante lo que consideraba un déficit importante en la información bancaria cuando solamente se publicitaba la Tasa de Interés Nominal (TIN). Andrés Yebra consideraba que las malas prácticas de las entidades financieras eran habituales y que también tenía responsabilidad el Banco de España como supervisor de la actividad bancaria. " +
                        "En septiembre de 1990, después de una dura pelea contra cajas y bancos, vio la luz una circular del Banco de España sobre Transparencia de las Operaciones Financieras y Protección de la Clientela que creaba la TAE y obligaba a su publicidad en los créditos bancarios.");
                break;
            case R.id.buttonTipo:
                textView16.setText("Texto del botón 2");
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}