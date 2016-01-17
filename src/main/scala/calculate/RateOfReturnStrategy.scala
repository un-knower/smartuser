package calculate

import stock.Stock
import config.StrategyConig


/**
  * Created by yangshuai on 2016/1/15
  * 回报率计算策略
  */
trait RateOfReturnStrategy {

  def calculate(t:Stock, r:Stock):Float

}

object RateOfReturnStrategy {

  def apply(sType: Int): RateOfReturnStrategy = {
    if (sType == StrategyConig.STRATEGY_ONE) {
      new StockStrategyOne
    } else  {
      new StockStrategyTwo
    }
  }
}
