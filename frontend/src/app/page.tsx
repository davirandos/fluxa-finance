import Image from "next/image";
import { Button } from "./components/Button/Button";

export default function Home() {
  return (
    <div className="flex flex-col flex-1 items-center justify-center bg-zinc-50 font-sans dark:bg-black">

      <main className="flex flex-1 w-full max-w-3xl flex-col items-center justify-between py-32 px-16 bg-white dark:bg-black sm:items-start">

        <h1 className="text-6xl">Vai tomar no cu Juan</h1>
        <Button onClick={() => console.log("clicloaaaaaau parabes")}>Salsadr</Button>
        <Button onClick={() => console.log("cliclou parabes")}>Salvar</Button>
        
      </main>
    </div>
  );
}