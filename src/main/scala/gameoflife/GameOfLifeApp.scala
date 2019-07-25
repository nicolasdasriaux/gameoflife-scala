package gameoflife

object GameOfLifeApp {
  def main(args: Array[String]): Unit = {
    val path = GameOfLifeApp.getClass.getResource("/grid.txt").getPath
    val (grid, area) = Grid.load("C:\\development\\gameoflife-scala\\src\\main\\resources\\cg.txt")

    val grids = Iterator.iterate(grid)(_.nextGridState)

    grids.take(300).foreach { grid =>
      println("\u001b[H\u001b[2J")
      println(Grid.toDisplayString(grid, area))
      Thread.sleep(100)
    }
  }
}
