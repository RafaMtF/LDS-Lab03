import {Button} from "@/components/ui/button";
import Link from "next/link";

export default function Home() {
    return (
        <div className="grid grid-cols-4 p-4 gap-2">
            <div></div>
            <Button>
                <Link href="aluno">Aluno</Link>
            </Button>

            <Button>
                <Link href="empresa-parceira">Empresa Parceira</Link>
            </Button>
            <div></div>
        </div>
    );
}
