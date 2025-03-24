class DiscountStrategy {
    applyDiscount(price) {
        throw new Error("applyDiscount moet worden geïmplementeerd!");
    }
}

class NoDiscount extends DiscountStrategy {
    applyDiscount(price) {
        return price;
    }
}

class PercentageDiscount extends DiscountStrategy {
    constructor(percentage) {
        super();
        this.percentage = percentage;
    }

    applyDiscount(price) {
        return price - (price * this.percentage / 100);
    }
}

class FixedDiscount extends DiscountStrategy {
    constructor(amount) {
        super();
        this.amount = amount;
    }

    applyDiscount(price) {
        return Math.max(0, price - this.amount);
    }
}

class ShoppingCart {
    constructor(discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    calculateTotal(price) {
        return this.discountStrategy.applyDiscount(price);
    }
}