class Fraction {
    private int n;
    private int d;
    public Fraction(int n, int d) {
        this.n = n;
        if (d == 0) {
            System.out.println("Error! Zero Denominator, setting it to 1");
            d = 1;
        } else {
            this.d = d;
        }
    }
    public Fraction() {
        this.n = 0;
        this.d = 1;
    }
    public Fraction(String f) {
        int slashindex = f.indexOf("/");
        String num = f.substring(0, slashindex);
        String den = f.substring(slashindex+1);
        this.n = Integer.parseInt(num);
        int tempD = Integer.parseInt(den);
        if (tempD == 0) {
            System.out.println("Error! Zero Denominator, setting it to 1");
            d = 1;
        } else {
            this.d = tempD;
        }
    }
    public Fraction(Fraction f) {
        this.n = f.n;
        this.d = f.d;
    }
    public int getNum() {
        return this.n;
    }
    public int getDenom() {
        return this.d;
    }
    public String toString() {
        return this.getNum() + "/" + this.getDenom();
    }
    public double toDecimal() {
        double dubnum = this.n;
        return dubnum/this.d;
    }
    public void reduce() { 
        int gcd = gcd(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd; 
    }
    public static Fraction add (Fraction a, Fraction b) {
        int newNum = a.n * b.d + b.n * a.d;
        int newDen = a.d * b.d;
        Fraction ans = new Fraction(newNum, newDen);
        ans.reduce();
        return ans;
    }
    public static Fraction subtract (Fraction a, Fraction b) {      
        int newNum = a.n * b.d - b.n * a.d;
        int newDen = a.d * b.d;
        Fraction ans = new Fraction(newNum, newDen);
        ans.reduce();
        return ans;
    }
    public static Fraction multiply(Fraction a, Fraction b) {
        int newNum = a.n * b.n;
        int newDen = a.d * b.d;
        Fraction ans = new Fraction(newNum , newDen);
        ans.reduce();
        return ans;
    }
    public static Fraction divide(Fraction a, Fraction b) {
        if (b.n == 0) {
            System.out.println("Error, cannot divide by zero; returning a default fraction");
            return new Fraction();
        } else {
            Fraction reciprocal = b.getReciprocal();
            Fraction ans = Fraction.multiply(a, reciprocal);
            ans.reduce();
            return ans;
        }
    }
    private Fraction getReciprocal() {
        Fraction reciprocal = new Fraction(this.d, this.n);
        return reciprocal;
    }
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0)
        {
            return 1;
        }
        while (a != b)
        {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    public void multiply(Fraction f){
        this.n=this.n * f.n;
        this.d *= f.d;
        this.reduce();
    }
}