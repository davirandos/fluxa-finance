interface ButtonProps {
    children: string;
    onClick?: () => void;
    disabled?: boolean;
}

export function Button ({children, onClick, disabled = false } : ButtonProps) {
	return (
        <button
            type="button"
            onClick={onClick}
            disabled={disabled}
            className="px-4 py-2 rounded-md bg-blue-900 text-white hover:bg-blue-600 disable:opacity-50">{children}</button>
    );
}
