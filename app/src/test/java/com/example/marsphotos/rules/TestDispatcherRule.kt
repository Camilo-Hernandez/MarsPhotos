package com.example.marsphotos.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description


class TestDispatcherRule @OptIn(ExperimentalCoroutinesApi::class) constructor(
    /**
     * Este parámetro de constructor debe tener un valor predeterminado establecido en una
     * instancia del objeto UnconfinedTestDispatcher. La clase UnconfinedTestDispatcher hereda
     * de la clase TestDispatcher y especifica que las tareas no se deben ejecutar en ningún
     * orden en particular. Este patrón de ejecución es adecuado para pruebas simples, ya que
     * las corrutinas se manejan automáticamente. A diferencia de UnconfinedTestDispatcher,
     * la clase StandardTestDispatcher habilita el control total de la ejecución de corrutinas.
     * De esta manera, se prefiere para pruebas complicadas que requieren un enfoque manual,
     * pero no es necesario para las pruebas de este codelab.
     */
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }

}